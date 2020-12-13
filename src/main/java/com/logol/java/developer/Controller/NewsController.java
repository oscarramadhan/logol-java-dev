package com.logol.java.developer.Controller;

import java.util.List;

import javax.validation.Valid;

import com.logol.java.developer.Entity.News;
import com.logol.java.developer.Model.RequestCreateNews;
import com.logol.java.developer.Model.RequestNewsByFilter;
import com.logol.java.developer.Model.RequestUpdateNews;
import com.logol.java.developer.Model.ResponseModel;
import com.logol.java.developer.Service.INewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    INewsService iNewsService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@Valid @RequestBody RequestCreateNews requestNews) {
        ResponseModel responseModel = new ResponseModel();
        try {
            iNewsService.create(requestNews);
            responseModel.setCode("201");
            responseModel.setDescription("Created");
            responseModel.setContent("");
            
            return new ResponseEntity<>(responseModel, HttpStatus.CREATED);
        } catch (Exception e) {
            responseModel.setCode("500");
            responseModel.setDescription("There is an Error");
            responseModel.setContent(e.getMessage());
            
            return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@Valid @RequestBody RequestUpdateNews requestUpdateNews) {
        ResponseModel responseModel = new ResponseModel();
        try {
            News result = iNewsService.update(requestUpdateNews);
            if (result != null) {
                responseModel.setCode("200");
                responseModel.setDescription("Updated");
                responseModel.setContent(result);
            } else {
                responseModel.setCode("404");
                responseModel.setDescription("News with id " + requestUpdateNews.getId() + " not found");
                responseModel.setContent(requestUpdateNews);
            }
            
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            responseModel.setCode("500");
            responseModel.setDescription("There is an Error");
            responseModel.setContent(e.getMessage());
            
            return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@Valid @PathVariable String id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            News news = iNewsService.delete(id);

            if (news != null) {
                responseModel.setCode("200");
                responseModel.setDescription("Deleted");
                responseModel.setContent(news);
            } else {
                responseModel.setCode("404");
                responseModel.setDescription("News with id " + id + " not found");
                responseModel.setContent(id);
            }
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            responseModel.setCode("500");
            responseModel.setDescription("There is an Error");
            responseModel.setContent(e.getMessage());

            return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@Valid @PathVariable String id) {
        ResponseModel responseModel = new ResponseModel();
        try {
            News news = iNewsService.getNewsById(id);

            if (news != null) {
                responseModel.setCode("200");
                responseModel.setDescription("Success");
                responseModel.setContent(news);
            } else {
                responseModel.setCode("404");
                responseModel.setDescription("News with id " + id + " not found");
                responseModel.setContent(id);
            }
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            responseModel.setCode("500");
            responseModel.setDescription("There is an Error");
            responseModel.setContent(e.getMessage());

            return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "getByFilter", method = RequestMethod.POST)
    public ResponseEntity<?> getByFilter(@RequestBody RequestNewsByFilter requestNewsByFilter) {
        ResponseModel responseModel = new ResponseModel();
        try {
            List<News> newsList = iNewsService.getNewsByFilterAndSort(requestNewsByFilter);
            responseModel.setCode("200");
            responseModel.setDescription("Success");
            responseModel.setContent(newsList);
            return new ResponseEntity<>(responseModel, HttpStatus.OK);
        } catch (Exception e) {
            responseModel.setCode("500");
            responseModel.setDescription("There is an Error");
            responseModel.setContent(e.getMessage());

            return new ResponseEntity<>(responseModel, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}