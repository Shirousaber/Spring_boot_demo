package com.example.demo.controller;

import com.example.demo.dto.AccessTokenDto;
import com.example.demo.dto.GithubUser;
import com.example.demo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubprovider;
    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state")String state)
    {
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        accessTokenDto.setState(state);
        accessTokenDto.setClient_id("bbda83650964e4ffed80");
        accessTokenDto.setClient_secret("153c70050fadaff8fe720d0f32ee2b6de6f75665");
        accessTokenDto.setRedirect_uri("http://localhost:8080/callback");
        String accessToken = githubprovider.getAccessToekn(accessTokenDto);
        GithubUser user = githubprovider.getUser(accessToken);
        System.out.println(user.getName());
        return "index.html";
    }
}
