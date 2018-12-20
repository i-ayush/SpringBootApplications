package springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	private List<Topic> topics= Arrays.asList(
			new Topic("Spring","SpringBoot","This is Spring Boot"),
			new Topic("Java","Java 1.8","This is Java 1.8"),
			new Topic("JavaScript","NodeJS","This is NodeJS")
			);	

	public List<Topic> getAllTopics()
	{
		return topics;
	}
}
