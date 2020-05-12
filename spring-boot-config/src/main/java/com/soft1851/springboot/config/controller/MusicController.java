package com.soft1851.springboot.config.controller;

import com.soft1851.springboot.config.model.Music;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName MusicController
 * @Description TODO
 * @Author 田震
 * @Date 2020/5/12
 **/
@RestController
@Slf4j
public class MusicController {
    @Resource
    private Music music;

    public MusicController(Music music) {
        this.music = music;
    }
    @Value("${music.name}")
    private String name;

    @GetMapping("/music")
    public Music music() {
        log.info(String.valueOf(music));
        log.info(name);
        return music;
    }
}