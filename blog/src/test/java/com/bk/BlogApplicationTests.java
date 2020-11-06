package com.bk;

import com.bk.service.BlogService;
import com.bk.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpSession;

@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @Test
    void contextLoads(HttpSession session) {

    }

}
