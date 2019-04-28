package uz.gidtashkent.newssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private NewsService _newsService;

    @RequestMapping(value = "/news")
    public ResponseEntity<List> TestApi()
    {
        List<News> _newslist = _newsService.GetAllNews(null);

        return new ResponseEntity<List>(_newslist , HttpStatus.OK);
    }

    @RequestMapping("/news/{nid}")
    public News getNews(@PathVariable("nid") long id)
    {
        return _newsService.GetNews(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/news")
    public void addNews(@RequestBody News news)
    {
        _newsService.AddNews(news);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/news/{id}")
    public void updateNews(@RequestBody News news, @PathVariable long id)
    {
        _newsService.UpdateNews(news, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/news/{id}")
    public void deleteNews(@PathVariable long id)
    {
        _newsService.deleteNews(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/publish/{id}")
    public void publish(@PathVariable long id)
    {
        _newsService.PublishNews(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/archive/{id}")
    public void archive(@PathVariable long id)
    {
        _newsService.ArchiveNews(id);
    }
}
