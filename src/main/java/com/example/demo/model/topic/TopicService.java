package com.example.demo.model.topic;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<> (Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "core java", "core java description"),
            new Topic("javascript", "javaScript", "javaScript description")
        ));

    public List<Topic> getAllTopics(){
        return topics;
    }
        
    public Topic getTopic(String id){
        return topics.stream()
            .filter(
                t -> t.getId()
                        .equals(id))
                            .findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic){
        for(int i=0; i< topics.size();i++){
            Topic t = topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id, Topic topic){
        topics.removeIf(t -> t.getId().equals(id));
    }
}
