
<a name="readme-top"></a>

<h3 align="center">My Dojo</h3>
<h4 align="center">Hackbright  Capstone Project</h4>

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

MyDojo - web application for a martial art studio and its clients. Clients can 
discover and book classes, integrate studio schedules with their calendars, 
see the paperwork, and manage their and their dependants' accounts. Staff can 
view and update their programs, see students' attendance statistics, etc.



![Schedule-Page-shield]

<h5>Guests' view:</h5>

* Guests can see studios class schedule, coaches working there and tournaments 
happening in the Judo world.
* Learn more about history of martial arts
* Request a free trial class
![Guests-Page-shield]

<h5>Students' view :</h5>
* Students can sign up for classes and tournaments
* Manage their accounts
![Student-View-shield]

<h5>Coaches' view :</h5>
* Coaches can add new classes and tournaments
* Sign up students to classes and tournaments
* Manage their accounts
![Student-View-shield]

<h5>Admins view :</h5>
* Admin can create and edit all accounts (students, coaches)
* Create and edit classes and tournaments
![Coach-View-shield]

<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Built With
Backend is powered with Java-based **_Spring Boot_** framework and **_Hibernate_** as its ORM.
The front-end is written with **_React.js_**.

[![Java][Java-shield]][Java-url]
[![SpringBoot][SpringBoot-shield]][SpringBoot-url]
[![React][React-shield]][React-url]
[![React-Router][React-Router-shield]][React-Router-url]
[![Bootstrap][Bootstrap-shield]][Bootstrap-url]
[![Hibernate][Hibernate-shield]][Hibernate-url]

Front-end reads the information from the database through Axios, promise-based HTTP client for node.js and the browser. 
To allow that, Cross-Origin Resource Sharing is enabled on the Spring Boot side.
```shell
import axios from "axios"

class CoachDataService{
    retrieveAllCoaches(){
        console.log("retrieveAllCoaches called")
        return axios.get(`http://localhost:8080/api/coaches/all`)
    }
```

```shell
@CrossOrigin
@RestController
@RequestMapping("/api/coaches")
```
The security and users privileges scope implemented though the super class 
**User** with additional boolean parameters.
```shell
 @Column
    private Boolean isAdmin;
```
### Challenges
##### Many-to-many relationship
The tricky part of this project was Many-toMany relationships implementation, 
mostly all classes are related to each other in many-to-many manner. 
For example, Students can be signed up for multiple Classes and every Class 
has multiple students; Coaches can teach multiple Classes and each Class may 
have a few coaches teaching it.

```shell
 @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "students_lessons", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {@JoinColumn(name = "lesson_id")})
    private Set<Lesson> lessonSet = new HashSet<>();
```

```shell
 @ManyToMany(mappedBy = "lessonSet")
    private Set<Student> studentSet;
```

```shell
 @Override
    public void addStudentToLessonSet(Long lessonId, Long studentId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        if (!lessonOptional.isPresent()) {
            System.out.println("addStudentToLessonSet lesson not found: " + lessonId);
            return;
        }
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (!studentOptional.isPresent()) {
            System.out.println("addStudentToLessonSet student not found: " + studentId);
            return;
        }
        Lesson lesson = lessonOptional.get();
        lesson.getStudentSet().add(studentOptional.get());
        studentOptional.get().getLessonSet().add(lesson);
        lessonRepository.saveAndFlush(lesson);
    }
```
```shell
 @Override
    public void deleteStudentFromLesson(Long lessonId, Long studentId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if (lessonOptional.isPresent() && studentOptional.isPresent()) {
            lessonOptional.get().getStudentSet().remove(studentOptional.get());
            studentOptional.get().getLessonSet().remove(lessonOptional.get());
            lessonRepository.saveAndFlush(lessonOptional.get());
            studentRepository.saveAndFlush(studentOptional.get());
        }
    }
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

### Prerequisites - Back-end
This section will help you install the software needed to run the backed part if
you don’t have it installed:

* Visit [jdk.java.net](https://jdk.java.net/)
* Alternatively, AWS provides an easy-to-install JDK known as [Amazon Corretto](https://aws.amazon.com/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)
* Click on the largest version in “Ready for use”
* Click on your preferred OS (Mac, Windows, or Linux) and continue installation depending on your OS

#### Windows
* Download the file and unzip into Program Files directory/folder
* Copy path to the unzipped program
* In Windows Settings app, search for env, and click Edit System Environment Variables
* Under System variables click New
* Variable name = ```JAVA_HOME ```, value = path you pasted to jdk unzip, then click **OK**

Update existing variable- ```PATH```
* Find ```PATH``` in list, click **edit**
* Click **New**
* Paste path to jdk such as ```C:\Program Files\jdk-17.0.1```
* Add ```\bin```

#### Mac
Follow the instructions for [Amazon Corretto](https://aws.amazon.com/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)

Then in **~/.bash_profile**, execute the following:
```
export PATH=$HOME/Library/Java/JavaVirtualMachines/jdk-16.jdk/bin:$PATH
```
```
export JAVA_HOME=$HOME/Library/Java/JavaVirtualMachines/jdk-16.jdk/bin
```
and then…
```shell
$ source .bash_profile
```
#### Verify Successful Installation
Run the following command to verify your installation:
```shell
$ java --version
```
### Prerequisites - Front-end
* Open **Terminal**
* Install npm
```shell
npm install npm@latest -g
```
* Install required dependencies
```shell
npm add axios
npm add moment
npm add formik
```

### Installation
* Copy the [URL](https://github.com/asya-code/MyDojo.git) for the repository
* Open **Terminal**
* Change the current working directory to the location where you want the cloned directory.
* Type git clone, and then paste the URL you copied earlier.
   ```sh
   git clone https://github.com/asya-code/MyDojo.git
   ```
* Press **Enter** to create your local clone.
```shell
$ git clone https://github.com/asya-code/MyDojo.git
> Cloning into `CoolProject`...
> remote: Counting objects: 74, done.
> remote: Compressing objects: 100% (74/74), done.
> remove: Total 10 (delta 1), reused 10 (delta 1)
> Unpacking objects: 100% (74/74), done.
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]:https://img.shields.io/badge/CONTRIBUTERS-5-green
[contributors-url]: https://github.com/ileanahi/doctors-office/graphs/contributors
[forks-shield]: https://img.shields.io/badge/FORKS-2-blue
[forks-url]: https://github.com/ileanahi/doctors-office/network/members
[issues-shield]: https://img.shields.io/badge/ISSUES-0%20OPEN-yellow
[issues-url]: https://github.com/ileanahi/doctors-office/issues
[Java-shield]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=&logoColor=white
[Java-url]: https://www.java.com/en
[React-shield]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[React-Router-shield]: https://img.shields.io/badge/React_Router-CA4245?style=for-the-badge&logo=react-router&logoColor=white
[React-Router-url]: https://reactrouter.com/en/main
[Bootstrap-shield]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com/
[SpringBoot-shield]: https://img.shields.io/badge/SpringBoot-8fce00?style=for-the-badge&logo=springboot&logoColor=white
[SpringBoot-url]: https://spring.io/
[Hibernate-shield]: https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white
[Hibernate-url]: https://hibernate.org/
[Schedule-Page-shield]: http://www.dawave.com/images/kano.jpg?crc=4241564927
[Guests-Page-shield]: http://www.dawave.com/images/kano.jpg?crc=4241564927
[Student-View-shield]: http://www.dawave.com/images/kano.jpg?crc=4241564927
[Coach-View-shield]: http://www.dawave.com/images/kano.jpg?crc=4241564927
[Admin-View-shield]: http://www.dawave.com/images/kano.jpg?crc=4241564927