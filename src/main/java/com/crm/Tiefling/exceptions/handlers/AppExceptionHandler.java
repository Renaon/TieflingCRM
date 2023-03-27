package com.crm.Tiefling.exceptions.handlers;

import com.crm.Tiefling.exceptions.FileStorageException;
import com.crm.Tiefling.exceptions.ResourceNotFoundException;
import com.crm.Tiefling.exceptions.UserExistsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(FileStorageException.class)
    public ModelAndView fileStorageException(FileStorageException e,
                                             RedirectAttributes redirectAttributes){
        ModelAndView view = new ModelAndView();
        view.addObject("message", e.getMessage());
        view.setViewName("error");
        return view;
    }

    @ExceptionHandler(UserExistsException.class)
    public ModelAndView userExistsException(UserExistsException e,
                                            RedirectAttributes redirectAttributes){
        ModelAndView view = new ModelAndView();
        view.addObject("message", e.getMessage());
        view.setViewName("error");
        return view;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView resourceNotFoundException(ResourceNotFoundException e,
                                                  RedirectAttributes redirectAttributes){
        ModelAndView view = new ModelAndView();
        view.addObject("message", e.getMessage());
        view.setViewName("error");
        return view;
    }
}
