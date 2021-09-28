package com.hayagou.generic;

import java.util.Arrays;

public class WildCardEx {

    private static void print(Course<?> course) {
        System.out.println(course.getName() + " 수강생" + Arrays.toString(course.getStudents()));
    }

    public static void registerCourse(Course<?> course) {
        print(course);
    }

    public static void registerCourseStudent(Course<? extends Student> course) {
        print(course);
    }

    public static void registerCourseWorker(Course<? super Worker> course) {
        print(course);
    }

    public static void main(String[] args) {
        Course<Person> personCourse = new Course<>("일반인 과정", 5);
        personCourse.add(new Person("일반인"));
        personCourse.add(new Worker("직장인"));
        personCourse.add(new Student("학생"));
        personCourse.add(new HighStudent("고등학생"));


    }
}
