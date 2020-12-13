package com.logol.java.developer.Service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import com.logol.java.developer.Entity.News;
import com.logol.java.developer.Model.RequestCreateNews;
import com.logol.java.developer.Model.RequestNewsByFilter;
import com.logol.java.developer.Model.RequestUpdateNews;
import com.logol.java.developer.Repository.INewsRepository;
import com.logol.java.developer.Utility.GeneratorUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class NewsService implements INewsService {
    @Autowired
    INewsRepository iNewsRepository;

    @Override
    public void create(RequestCreateNews requestNews) {
        String uuid = GeneratorUtil.GenerateUuid();

        News news = new News();
        news.setId(uuid);
        news.setTitle(requestNews.getTitle());
        news.setDescription(requestNews.getDescription());

        news.setCreatedAt(new Date());
        iNewsRepository.save(news);
    }

    @Override
    public News update(RequestUpdateNews news) {
        News result = iNewsRepository.findOneById(news.getId());

        if (result != null) {
            result.setTitle(news.getTitle());
            result.setDescription(news.getDescription());
            iNewsRepository.save(result);
        }

        return result;
    }

    @Override
    public News delete(String id) {
        News result = iNewsRepository.findOneById(id);

        if (result != null) {
            iNewsRepository.delete(result);
        }

        return result;
    }

    @Override
    public News getNewsById(String id) {
        News result = iNewsRepository.findOneById(id);

        return result;
    }

    @Override
    public List<News> getNewsByFilterAndSort(RequestNewsByFilter requestNewsByFilter) {
        Pageable pageable = Pageable.unpaged(); 
        
        if(requestNewsByFilter.getSortType().equalsIgnoreCase("ASC")){
            pageable = PageRequest.of(requestNewsByFilter.getPage() - 1, requestNewsByFilter.getSize(),
                Sort.by(requestNewsByFilter.getSortColumn()).ascending());
        } else {
            pageable = PageRequest.of(requestNewsByFilter.getPage() - 1, requestNewsByFilter.getSize(),
               Sort.by(requestNewsByFilter.getSortColumn()).descending());
        }

        List<News> news = iNewsRepository.getByFilterAndSortByColumn(
            requestNewsByFilter.getTitle().isEmpty() ? null : requestNewsByFilter.getTitle(), 
            requestNewsByFilter.getDescription().isEmpty() ? null : requestNewsByFilter.getDescription(),
            requestNewsByFilter.getCreatedFrom(), 
            requestNewsByFilter.getCreatedTo(), 
            pageable
        );
        return  news;
    }

}