package com.mydojo.configuration;

import com.mydojo.*;
import com.mydojo.entites.*;
import com.mydojo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class SeedDB implements CommandLineRunner{
    @Autowired
    private CoachRepository coachRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String ... args) throws Exception{
        Date date = new Date();
        System.out.println("****************************Generation Coaches**************************************");
        Coach coach = new Coach("Brad", "Burgo", "", null, "brad@email.com", "https://static.wixstatic.com/media/e413be_ccd0667ef79540819a7e009760c19fcb.jpg/v1/fill/w_255,h_280,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/e413be_ccd0667ef79540819a7e009760c19fcb.jpg",
                "1991", "6th Degree RED/WHITE belt Judo and Japanese Ju Jitsu", "Sensei Brad Burgo has developed along decades of experience - at the competitive level and the mentorship level - a unique and effective way of teaching Judo. He teaches a deep concept on \"foot work\", perfect posture and balance development in a process of producing a good foundation.");
        System.out.println(coach);
        coachRepository.saveAndFlush(coach);

        Coach coach2 = new Coach("Joe", "DeBatista", "", null, "joe@email.com", "https://static.wixstatic.com/media/3d9d66_d26836911bed474b94afa08e41f69d4c.jpg/v1/fill/w_167,h_175,al_c,q_80,usm_0.66_1.00_0.01,enc_auto/3d9d66_d26836911bed474b94afa08e41f69d4c.jpg",
                "1983", "7th Degree BLACK belt Judo and Japanese Ju Jitsu", "Professor Joe DeBattista started training in Judo and JuJitsu in 1970, from a Physical Ed class in college.\n" +
                "\n" +
                "He fell in love with Judo and started looking for a dojo to further his training. Having visited various dojos in the area, he discovered Cahill’s Judo and JuJitsu. Unlike some of the traditional schools, Willy Cahill’s sense of Kokua (hospitality) and Ohana (feeling of family) was very strong, and he immediately knew this was to be his dojo. It was a place that you could train hard for competition with some of the top coaches, while still having fun learning the techniques.\n" +
                "\n" +
                " \n" +
                "\n" +
                "While serving in the Navy, he kept up his training always having his gi with him and looking for dojos to visit and practice. During a stint with the Military Police in the Philippines, he was tasked with teaching defensive techniques to newly assigned personnel, and later to military family members.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Joe feels privileged that he has had a chance to train and learn from some of the best martial artists in the world, but also from his students. He says that they all help to make him a better teacher.\n" +
                "\n" +
                " \n" +
                "\n" +
                "He has taught classes and seminars around the world, and throughout the United States, and is currently one of the main JuJitsu instructors at Cahill’s. Joe says that he loves it when his students master that difficult technique, and get that sense of accomplishment.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Professor DeBattista currently holds the rank of Sichidan (7th Degree black belt) in Kodenkan JuJitsu (sometimes referred to as DanZanRyu Jujitsu) from JuJitsu America, and a Nidan (2nd Degree black belt) in Kodokan Judo through the United States Judo Association. He is also on the Board of Directors for the JuJitsu America organization, and a certified Referee for Sport Jujitsu.\n" +
                "\n");
        System.out.println(coach2);
        coachRepository.saveAndFlush(coach2);

        Coach coach3 = new Coach("Chris", "Hardy", "", null, "chris@email.com","",
                "1989", "4th Degree BLACK belt", "Chris Hardy is Yodan, fourth degree black belt, in Kodenkan Jujitsu and Sandan, third degree black belt, in Kodokan Judo. He's been an instructor at Cahill's Judo Academy since 1998, also helping out with the Paralympic Blind Judo Team. He also teaches judo at the Academy of Art University, the only art school in the country with a judo program.");
        System.out.println(coach3);
        coachRepository.saveAndFlush(coach3);

        System.out.println("****************************Generation Lessons**************************************");
        Lesson lesson = new Lesson("Adult Kodenkan Jujitsu", "Jujitsu","Monday", "6 pm", "For all levels from beginner to black belt, concentrating on instruction of the basic principles of Kodokan Jujitsu");
        System.out.println(lesson);
        lessonRepository.saveAndFlush(lesson);
        Lesson lesson1 = new Lesson("Kids Judo", "Judo", "Tuesday", "5:30 pm to 7pm", "For kids 10 and older, who have been competing in judo for some time\n" +
                "\n");
        lessonRepository.saveAndFlush(lesson1);

        Lesson lesson2 = new Lesson("Advanced Juniors Judo", "Judo", "Tuesday", "5:30pm to 7pm", "For kids 10 and older, who have been competing in judo for some time");
        lessonRepository.saveAndFlush(lesson2);

        Lesson lesson3 = new Lesson("Adult Fundamentals Judo", "Judo", "Tuesday","7pm to 9pm", "For all levels from beginner to black belt, concentrating on instruction of the basic principles of Kodokan Judo");
        lessonRepository.saveAndFlush(lesson3);

        Lesson lesson4 = new Lesson("Beginner Judo", "Judo", "Wednesday","4pm to 5pm", "For kids 5 and older, just starting out in judo");
        lessonRepository.saveAndFlush(lesson4);

        Lesson lesson5 = new Lesson("Kids Judo", "Judo", "Wednesday","5pm to 6pm", "For kids 7 and older, just starting out in judo");
        lessonRepository.saveAndFlush(lesson5);

        Lesson lesson6 = new Lesson("Kids Kodenkan Jujitsu", "Jujitsu", "Wednesday","5pm to 6pm", "For kids 7 and older, just starting out in Kodenkan Jujitsu");
        lessonRepository.saveAndFlush(lesson6);

        Lesson lesson7 = new Lesson("Adult Kodenkan Jujitsu", "Jujitsu", "Wednesday","6pm to 7:30pm", "For all levels from beginner to black belt, concentrating on instruction of the basic principles of Kodokan Jujitsu");
        lessonRepository.saveAndFlush(lesson7);

        Lesson lesson8 = new Lesson("Kids Judo", "Judo", "Thursday","4pm to 5:30pm", "For kids 7 and older, starting out in competitive judo");
        lessonRepository.saveAndFlush(lesson8);

        Lesson lesson9 = new Lesson("Advanced Juniors Judo", "Judo", "Thursday", "5:30pm to 7pm", "For kids 10 and older, who have been competing in judo for some time");
        lessonRepository.saveAndFlush(lesson9);

        Lesson lesson10 = new Lesson("Adult Fundamentals Judo", "Judo", "Tuesday","7pm to 9pm", "For all levels from beginner to black belt, concentrating on instruction of the basic principles of Kodokan Judo");
        lessonRepository.saveAndFlush(lesson10);

        Lesson lesson11 = new Lesson("Beginner Judo", "Judo", "Saturday","8:30 am to 9:30 am", "For kids 5 and older, just starting out in judo");
        lessonRepository.saveAndFlush(lesson11);


        Lesson lesson12 = new Lesson("Kids Judo", "Judo", "Saturday","9:30 am to 10:30 am", "For kids 7 and older, just starting out in judo");
        lessonRepository.saveAndFlush(lesson12);

        Lesson lesson13 = new Lesson("Kids Kodenkan Jujitsu", "Jujitsu", "Saturday","9:30 am to 10:30 am", "For kids 7 and older, just starting out in Kodenkan Jujitsu");
        lessonRepository.saveAndFlush(lesson13);

        Lesson lesson14 = new Lesson("Adult Fundamentals Judo", "Judo", "Saturday","11 am to 1 pm", "For all levels from beginner to black belt, concentrating on instruction of the basic principles of Kodokan Judo");
        lessonRepository.saveAndFlush(lesson14);

        Lesson lesson15 = new Lesson("Open Mat Judo Workout", "Judo", "Sunday","10 am to 12 pm", "For all levels, aimed toward competitive judo");
        lessonRepository.saveAndFlush(lesson15);

        System.out.println("****************************Generation Tournaments**************************************");
        Tournament tournament = new Tournament("Youth National Championships", "USA National Championships in Lubbock, Texas", "Judo", "youth", "March 18-19", "TBD");
                //String tournamentName, String description, String art, String age, String date, String time
        tournamentRepository.saveAndFlush(tournament);

        System.out.println("****************************Generation Students**************************************");
        Student student = new Student("Bilbo", "Beggins", "", "1946", "bbeggins@email.com", "",
                "1970", "Blue Belt");
        studentRepository.saveAndFlush(student);
        Student student1 = new Student("Samwise", "Gamgee", "", "1987", "sam@email.com", "",
                "2022", "Green Belt");
        studentRepository.saveAndFlush(student1);
        Student student2 = new Student("Thorin", "Oakenshield", "", "1976", "thorin@email.com", "",
                "2022", "Green Belt");
        studentRepository.saveAndFlush(student2);
        Student student3 = new Student("Gandalf", "Gray", "", "1929", "gandalf@email.com", "",
                "1937", "5th Degree Black Belt");
        studentRepository.saveAndFlush(student3);
        Student student4 = new Student("Frodo", "Baggins", "", "1991", "frodo@email.com", "",
                "2021", "White Belt");
        studentRepository.saveAndFlush(student4);
        Student student5 = new Student("Elrond", "Eärendil", "", "1002", "elrond@email.com", "",
                "1021", "10th Degree Black Belt");
        studentRepository.saveAndFlush(student5);
        Student student6 = new Student("Balin", "Fundin", "", "1981", "balin@email.com", "",
                "2011", "Green Belt");
        studentRepository.saveAndFlush(student6);
        Student student7 = new Student("Meriadoc", "Brandybuck", "", "1993", "merry@email.com", "",
                "2023", "White Belt");
        studentRepository.saveAndFlush(student7);
        Student student8 = new Student("Peregrin", "Took", "", "1993", "pippin@email.com", "",
                "2023", "White Belt");
        studentRepository.saveAndFlush(student8);
        //String firstName, String lastName, String middleName, String dob,
        //                 String email, String image, String started, String rank)
    }
}
