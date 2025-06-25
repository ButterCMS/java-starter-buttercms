package com.buttercms.springstarterbuttercms.service;

import com.buttercms.IButterCMSClient;
import com.buttercms.model.Post;
import com.buttercms.springstarterbuttercms.controller.dto.LandingPageDto;
import com.buttercms.springstarterbuttercms.model.landingpage.Fields;
import com.buttercms.springstarterbuttercms.model.navigation.MenuItem;
import com.buttercms.springstarterbuttercms.model.navigation.NavigationMenu;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PageCollectionService {

    private final IButterCMSClient butterCMSClient;

    private final static String DEFAULT_LANDING_PAGE = "landing-page-with-components";

    public PageCollectionService(IButterCMSClient butterCMSClient) {
        this.butterCMSClient = butterCMSClient;
    }

    public LandingPageDto getLandingPage(String pageType, String slug) {
        slug = slug == null ? DEFAULT_LANDING_PAGE : slug;
        // TODO: how to change this?
        Map<String, String> queryParams = new HashMap<String, String>() {{
            put("page", "1");
            put("page_size", "2");
        }};
        List<Post> posts = butterCMSClient.getPosts(queryParams).getData();
        Fields landingPage = butterCMSClient.getPage(
                pageType,
                slug,
                new HashMap<>(),
                Fields.class
        ).getData().getFields();
        return new LandingPageDto(landingPage, posts);
    }

    public List<MenuItem> getNavigation() {
        List<NavigationMenu> nav = butterCMSClient.getCollection(
                "navigation_menu",
                Collections.emptyMap(),
                NavigationMenu.class
        ).getData().getItems();
        return nav.stream()
                .filter(Objects::nonNull)
                .flatMap(navMenu -> navMenu.getMenuItems().stream())
                .collect(Collectors.toList());
    }
}
