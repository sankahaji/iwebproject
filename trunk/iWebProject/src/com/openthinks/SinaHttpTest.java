package com.openthinks;

import java.io.IOException;

import org.xml.sax.SAXException;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class SinaHttpTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
      try {
        //建立一个WebConversation实例
          WebConversation wc = new WebConversation();
          //向指定的URL发出请求
          WebRequest req = new PostMethodWebRequest("http://mail.sina.com.cn/cgi-bin/login.php");
          //给请求加上参数
          req.setParameter("u","zhangwenlong73@sina.com");
          req.setParameter("psw","329662570");
          //获取响应对象
          WebResponse resp = wc.getResponse(req);

          System.out.println( resp.getText() );
        } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SAXException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 

    }
}
