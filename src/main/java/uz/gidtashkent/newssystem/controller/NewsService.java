package uz.gidtashkent.newssystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    private ArrayList<String> _newsList;
    private List<News> _newslist  = new ArrayList<>();

    @Autowired
    private NewsRepository newsRepository;

    public NewsService()
    {
    }

    public List<News> GetAllNews(Integer page)
    {
        List<News> news = new ArrayList<News>();
        newsRepository.findByState(NewsState.Published).forEach(news::add);

        return  news;
    }

    public News GetNews(long id)
    {
        //return _newslist.stream().filter(t->t.getId() == id).findFirst().get();
        return newsRepository.findById(id).get();
    }


    public void AddNews(News news)
    {
        news.setState(NewsState.Created);

        newsRepository.save(news);
    }

    public void UpdateNews(News news, long id)
    {

        /*for(int i =0; i < _newslist.size(); i++)
        {
            News item = _newslist.get(i);

            if (item.getId() == id)
            {
                _newslist.set(i , news);
                return;
            }
        }*/

        newsRepository.save(news);
    }

    public void PublishNews(long id)
    {
        News toChange = newsRepository.findById(id).get();

        toChange.setState(NewsState.Published);

        newsRepository.save(toChange);
    }

    public void ArchiveNews(long id)
    {
        News toChange = newsRepository.findById(id).get();

        toChange.setState(NewsState.Arhive);

        newsRepository.save(toChange);
    }

    public void deleteNews(long id)
    {

        //_newslist.removeIf(t->t.getId() == id);

        newsRepository.deleteById(id);

    }
}
