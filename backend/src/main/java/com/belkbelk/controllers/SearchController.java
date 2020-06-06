package com.belkbelk.controllers;

import com.belkbelk.abstractclasses.AbstractDataSource;
import com.belkbelk.datastructures.EbayApiSearchResult;
import com.belkbelk.datastructures.resultobjects.LabeledCategory;
import com.belkbelk.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class SearchController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    @Qualifier("apiService")
    AbstractDataSource dataSource;

    @PostConstruct
    public void init() {
        System.out.println("controller operational");
    }

    @GetMapping("/get_examples")
    public Set<String> getExamples() {
        return dataSource.searchApiCall("shoes", "").getItemSummaries().stream().map(x -> x.getImage().getImageUrl()).collect(Collectors.toSet());
    }

    @GetMapping("/search")
    public EbayApiSearchResult getSearchResult(@RequestParam String query, @RequestParam String categoryIds) {
        return dataSource.searchApiCall(query, categoryIds);
    }

    @GetMapping("/categories")
    public List<LabeledCategory> getCategories() {
        return categoryService.getCategories();
    }

    @GetMapping("/load_more")
    public EbayApiSearchResult loadMore(@RequestParam String url) {
        return dataSource.loadMore(url);
    }

}
