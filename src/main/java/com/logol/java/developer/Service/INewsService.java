package com.logol.java.developer.Service;

import java.util.List;

import com.logol.java.developer.Entity.News;
import com.logol.java.developer.Model.RequestCreateNews;
import com.logol.java.developer.Model.RequestNewsByFilter;
import com.logol.java.developer.Model.RequestUpdateNews;

public interface INewsService {
    void create(RequestCreateNews news);
    News update(RequestUpdateNews news);
    News delete(String id);
    News getNewsById(String id);
    List<News> getNewsByFilterAndSort(RequestNewsByFilter requestNewsByFilter);
}