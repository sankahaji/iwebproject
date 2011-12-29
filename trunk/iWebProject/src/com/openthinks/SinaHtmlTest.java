package com.openthinks;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.params.CookiePolicy;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.FormEncodingType;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.util.Cookie;
import com.gargoylesoftware.htmlunit.util.KeyDataPair;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

public class SinaHtmlTest {
    private static WebClient client;
    private static WebRequest request;

    private static String sinaLoginUrl = "http://mail.sina.com.cn/cgi-bin/login.php";
    private static String hostSinaUrl = "";

    public static void main(String[] args)
            throws FailingHttpStatusCodeException, MalformedURLException,
            IOException {

        String username = "zhangwenlong73@sina.com";
        String password = "329662570";
        SinaHtmlTest mySina = new SinaHtmlTest();

        if (mySina.mailLoginBySina(username, password)) { // 登录
            System.out.println("登陆成功");
            //mySina.updatePwdBySina(password,"329662570");
//            HtmlPage indexPage = client.getPage("http://m1.mail.sina.com.cn/classic/index.php");
//            System.out.println(indexPage.getTitleText());
//            List<HtmlAnchor> anchorList = indexPage.getAnchors();
//            for(HtmlAnchor anchor : anchorList){
//                System.out.println(anchor.getTextContent());
//                System.out.println(anchor.getHrefAttribute());
//            }
            
            String token = mySina.sendMail("6b7de98aa3ce90a084ed1f76df3fe6214081b82b");
//            token = mySina.sendMail(token);
        } else {
            System.out.println("登录失败！请检查用户名和密码是否正确！");
        }
    }

    public SinaHtmlTest() {
        client = new WebClient(BrowserVersion.FIREFOX_3_6,"127.0.0.1", 8888);
        client.setJavaScriptEnabled(false);
        
//        CookieManager cookieManager = new CookieManager();
//        cookieManager.addCookie(new Cookie("_s_upa", "2"));
//        cookieManager.addCookie(new Cookie("Apache", "db865ff1.1fb9a0c.4efc04f9.c9fe6cc4"));
//        cookieManager.addCookie(new Cookie("EditorMenuRev", "base"));
//        cookieManager.addCookie(new Cookie("SGUP", "0"));
//        cookieManager.addCookie(new Cookie("SINAGLOBAL", "db865ff1.ba518946.4efa8129.37713a6d"));
//        cookieManager.addCookie(new Cookie("SUE", "es%3D9afdf4cd68e1919f33981a1bd23a5d82%26ev%3Dv1%26es2%3Dfac89f1b2f79b4e99892382e35112f83%26rs0%3DVU38JX6vuBO5B6gvfULlclgQJExNlie6r%252F7PTpPGMHltm5aiq2fv1ROkGJzJt9gIMo6PU4ra4gEChxICrNTOQBHUVbgsksbdI%252FqdWNVZPvNGQceWxogKqxwZuBlkbreRnZSSsmBNQP3ommcVKrpiNSZEgrZUrwk7MJUzw6GgFpM%253D%26rv%3D0"));
//        cookieManager.addCookie(new Cookie("SUP", "cv%3D1%26bt%3D1325139196%26et%3D1325225596%26d%3D40c3%26i%3D3d03%26us%3D1%26lt%3D1%26uid%3D2638432260%26user%3Dzhangwenlong73.%252A%252A%26ag%3D9%26name%3Dzhangwenlong73%2540sina.com%26nick%3Dzhangwenlong73%26sex%3D%26ps%3D0%26email%3Dzhangwenlong73%2540sina.com%26dob%3D%26ln%3Dzhangwenlong73%2540sina.com%26os%3D%26fmp%3D%26lcp%3D%26vf%3D0%26ac%3D0"));
//        cookieManager.addCookie(new Cookie("SUS", "SID-2638432260-1325139196-GZ-ousx7-bdde66e3b5c14bb42f40bd6ba7eb3d03"));
//        cookieManager.addCookie(new Cookie("SWEBAPPSESSID", "719f41e5663c95e4afc2a89d213d1556"));
//        cookieManager.addCookie(new Cookie("SWMHA", "SWMHA137"));
//        cookieManager.addCookie(new Cookie("U_TRS1", "000000f1.dc244b44.4efa8df6.ed6b7771"));
//        cookieManager.addCookie(new Cookie("U_TRS2", "000000f1.d643509c.4efc04fe.45ef233b"));
//        cookieManager.addCookie(new Cookie("ULOGIN_IMG", "3ca33d987c7bc6063200cba91c180885fe54"));
//        cookieManager.addCookie(new Cookie("ULV", "1325139198350:11:11:11:db865ff1.1fb9a0c.4efc04f9.c9fe6cc4:1325137490767"));
//        cookieManager.addCookie(new Cookie("UOR", ",mail,"));
//        cookieManager.addCookie(new Cookie("vjlast", "1325135519.1325135519.30"));
//        cookieManager.addCookie(new Cookie("vjuids", "1b00d3ff7.134883b5cbe.0.1df8aa963cfac8"));
//        cookieManager.addCookie(new Cookie("WTP_VISSTATUS", "TRUE"));
//        cookieManager.addCookie(new Cookie("WTP_VISTAB", "address"));
//        
//        client.setCookieManager(cookieManager);
    }

    /**
     * 登录
     * 
     * @param username
     *            用户名
     * @param password
     *            密码
     * @return boolean
     * @throws FailingHttpStatusCodeException
     * @throws MalformedURLException
     * @throws IOException
     */
    public boolean mailLoginBySina(String username, String password)
            throws FailingHttpStatusCodeException, MalformedURLException,
            IOException {

        HtmlPage loginPage = client.getPage(sinaLoginUrl);
        HtmlForm loginForm = loginPage.getFormByName("free");

        HtmlInput u = loginForm.getInputByName("u");
        HtmlInput psw = loginForm.getInputByName("psw");
        HtmlSubmitInput loginButton = loginForm.getInputByName("登录");

        u.setValueAttribute(username);
        psw.setValueAttribute(password);

        HtmlPage result = loginButton.click();
        String resultUrl = result.getUrl().toString();

        if (resultUrl.indexOf("classic/index.php") > 0) {

            String regex = "http://(.*?)/";
            hostSinaUrl = myRegex(resultUrl, regex, null);

            if (hostSinaUrl.length() > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    /**
     * 
     * 发送邮件
     * 
     * @param token
     * @throws FailingHttpStatusCodeException
     * @throws IOException
     */
    public String sendMail(String token)
            throws FailingHttpStatusCodeException, IOException {

        String sinaSetUrl = "http://m1.mail.sina.com.cn/classic/send.php?ts=1325144364033";

        request = new WebRequest(new URL(sinaSetUrl), HttpMethod.POST);
        
        request.setEncodingType(FormEncodingType.MULTIPART);
        request.setCharset("gbk");
        
        /*request.setRequestParameters(
                Arrays.asList(
                        new NameValuePair("from", "zhangwenlong73@sina.com"),     
                        new NameValuePair("to", "48587942@qq.com"),  
                        new NameValuePair("subj", "test"),  
                        new NameValuePair("type", "html"),     
                        new NameValuePair("body", "<font color='red'>red</font>"),  
                        new NameValuePair("saveSent", "1"),  
                        new NameValuePair("a_sendmail", "发送")));*/

        
        request.setRequestParameters(
                Arrays.asList(new NameValuePair("nickname", ""),
                        new NameValuePair("sender", "zhangwenlong73@sina.com"),
                        new NameValuePair("issend", "1"),         
                        new NameValuePair("savedraft", "0"),     
                        new NameValuePair("youxj", "3"),
                        new NameValuePair("type", "html"),     
                        new NameValuePair("authcode", ""),   
                        new NameValuePair("fid", ""),     
                        new NameValuePair("mid", ""),     
                        new NameValuePair("Server", "mail3-24"),     
                        new NameValuePair("sinafriends", "0"),     
                        new NameValuePair("token", "714d27e501e2d58cedfcf9f88be992d72d62b4a0"),     
                        new NameValuePair("paperid", "0"),     
                        new NameValuePair("bigfile", ""),     
                        new NameValuePair("bigfile_old", ""),  
                        new NameValuePair("sc", "0"),     
                        new NameValuePair("sendtime", ""),     
                        new NameValuePair("cr_mid", ""),   
                        new NameValuePair("cf_mid", ""),   
                        new NameValuePair("att_swf", ""),   
                        new NameValuePair("from", "zhangwenlong73@sina.com"),     
                        new NameValuePair("to", "\"329662570\" <48587942@qq.com>"),  
                        new NameValuePair("cc", ""),     
                        new NameValuePair("bcc", ""),     
                        new NameValuePair("subj", "test"),   
                        new KeyDataPair("atth0", new File(""), "", ""),
                        new KeyDataPair("atth0", new File(""), "", ""),   
                        new NameValuePair("msgtxt", "<style id='sinamailpaperfilter'>.sinamailpaper-0{cursor:text;}.sinamailpaper-0 td,.sinamailpaper-0 textarea,.sinamailpaper-0 input,.sinamailpaper-0 br,.sinamailpaper-0 div,.sinamailpaper-0 span{font-size:14px;font-family:'宋体',Verdana,Arial,Helvetica,sans-serif;line-height:1.5;}.sinamailpaper-0 p{/**margin:0.2em auto;*/margin:0px;}.sinamailpaper-0 img{border:0;}.sinamailpaper-0 pre{white-space:normal;}.sinamailpaper-0 form{margin:0;}body{font-size:14px;}p{margin:0px;}</style><br><br>test<br>"),
                        new NameValuePair("signatureline", ""),
                        new NameValuePair("snt", "2")));
        
        System.setProperty("apache.commons.httpclient.cookiespec", CookiePolicy.BROWSER_COMPATIBILITY);
        
        HtmlPage p = client.getPage(request);

        String result = p.getBody().getTextContent();

        System.out.println(token);
        System.out.println(result);

        token = result.substring(result.indexOf("token"),result.indexOf("spam"))
                    .replace("token\":\"", "")
                    .replace("\",\"", "");
        
        return token;
    }
    
    /**
     * 
     * 修改密码
     * 
     * @param oldpassword
     *            旧密码
     * @param newpassword
     *            新密码
     * @return boolean
     * @throws FailingHttpStatusCodeException
     * @throws IOException
     */
    public boolean updatePwdBySina(String oldpassword, String newpassword)
            throws FailingHttpStatusCodeException, IOException {
 
        String sinaSetUrl = "http://login.sina.com.cn/member/security/password.php";
         
        request = new WebRequest(new URL(sinaSetUrl),HttpMethod.POST);
 
        request.setCharset("gbk");
        request.setRequestParameters(Arrays.asList(
                new NameValuePair("pass",oldpassword),
                new NameValuePair("pass1", newpassword),
                new NameValuePair("pass2", newpassword)));
 
        HtmlPage p = client.getPage(request);
 
        if (p.getBody().getTextContent().indexOf("您的密码修改成功") > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * 
     * 正则匹配替换
     * 
     * @param str
     * @param reg
     * @param replace
     * @return
     */
    public String myRegex(String str, String reg, String[] replace) {

        String result = null;

        Matcher m = Pattern.compile(reg).matcher(str);

        while (m.find()) {

            result = m.group();

            if (replace != null && replace.length > 0) {

                for (String s : replace) {
                    result = result.replace(s, "");
                }
            }
        }
        return result;
    }
}
