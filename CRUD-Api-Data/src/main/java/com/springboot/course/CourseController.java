package com.springboot.course;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> AllCourses(@PathVariable String topicId)
	{
		return courseService.getAllCourses(topicId);
	}

	@RequestMapping("topics/{topicId}/courses/{Id}")
	public Optional<Course> getCourse(@PathVariable String Id)
	{
		return courseService.getCourse(Id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicID}/courses}")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id,@PathVariable String topicId)
	{
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course); 
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id)
	{
		courseService.deleteCourse(id);
	}
}
