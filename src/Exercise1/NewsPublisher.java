package Exercise1;

import java.util.ArrayList;
import java.util.List;

public class NewsPublisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String news;

    public void subscribe(Subscriber sub) { subscribers.add(sub); }
    public void unsubscribe(Subscriber sub) { subscribers.remove(sub); }

    public void addNews(String news) {
        this.news = news;
        notifySubscribers();
    }

    private void notifySubscribers() {
        for (Subscriber sub : subscribers) sub.update(news);
    }
}
