package dev.snds_prfct.main.controller;


import dev.snds_prfct.main.service.UserActivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final UserActivityService userActivityService;

    @GetMapping("/view")
    public void view() {
        userActivityService.registerView();
    }

    @PostMapping("/like")
    public void like() {
        userActivityService.registerLike();
    }

    @PostMapping("/repost")
    public void repost() {
        userActivityService.registerRepost();
    }
}
