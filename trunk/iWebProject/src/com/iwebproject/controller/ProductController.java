package com.iwebproject.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iwebproject.common.Constants;
import com.iwebproject.utils.FileUtils;

@Controller
@RequestMapping("/product")
public class ProductController {

    private Logger logger = Logger.getLogger(ProductController.class);

    @RequestMapping(value = "/{userId}/uploadProductPicture", method = RequestMethod.POST)
    public ModelAndView uploadFile(@PathVariable("userId") String userId,
            @RequestParam("productPicture") CommonsMultipartFile picture,
            HttpServletRequest request) {
        logger.info("picture size=" + picture.getBytes().length + ", name="
                + picture.getOriginalFilename());

        String fileName = picture.getOriginalFilename();
        String extName = FileUtils.getExtention(fileName).toLowerCase();

        String photoName = new Date().getTime() + extName;

        String photoPath = request.getSession().getServletContext()
                .getRealPath(Constants.PHOTO_DIRECTORY)
                + File.separator + userId + File.separator;

        try {
            File photoFile = new File(photoPath);
            if (!photoFile.exists()) {
                photoFile.mkdir();
            }
            picture.transferTo(new File(photoPath + photoName));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ModelAndView("/uploadProductPicture");
    }
}
