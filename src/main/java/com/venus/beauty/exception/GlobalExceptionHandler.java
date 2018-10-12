package com.venus.beauty.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lx
 * @time 2018/10/12
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    public static final String VENUS_ERROR = "error";

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultEooroHandler(HttpServletRequest request,Exception e) throws  Exception{
        ModelAndView mv = new ModelAndView();
        mv.addObject("exception",e);
        mv.addObject("url",request.getRequestURL());
        mv.setViewName(VENUS_ERROR);
        logger.info("info ===" + e);
        logger.error("error ===" + request.getRequestURL());
        logger.debug("debug ==== debug" );
        return mv;
    }
}
