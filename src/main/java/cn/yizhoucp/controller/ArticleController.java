package cn.yizhoucp.controller;
import cn.yizhoucp.model.ArticleModel;
import cn.yizhoucp.model.FormatResPonse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping("/rest")
@Slf4j
public class ArticleController {

    @GetMapping(value = "/v1/articles/{id}")
    public FormatResPonse getArticle(@PathVariable Long id){
        ArticleModel articleModel = ArticleModel.builder()
                .id(1L)
                .author("小米")
                .title("第一个标题")
                .content("第一篇文章的内容")
                .createTime(new Date()).build();
        log.info("article PoJo 数据---->"+articleModel);
        FormatResPonse formatResPonse = new FormatResPonse();
        return formatResPonse.success(articleModel,"数据查询成功");
    }

    @PostMapping(value = "/v1/articles")
    public FormatResPonse saveeArticle(@RequestBody ArticleModel articleModel){
        log.info("article PoJo 数据---->"+articleModel);
        FormatResPonse formatResPonse = new FormatResPonse();
        return formatResPonse.success(articleModel,"数据添加成功");
    }
}
