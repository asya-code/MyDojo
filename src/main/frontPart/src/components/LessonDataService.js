import axios from "axios"

class LessonDataService{
    retrieveAllLessons(){
        console.log("retrieveAllLessons called")
        return axios.get(`http://localhost:8080/api/classes`)
    }

    retrieveLesson(lessonId){
        return axios.get(`http://localhost:8080/api/classes/${lessonId}`)
    }

    addLesson(lesson) {
        return axios.post(`http://localhost:8080/api/classes/new-class`, lesson)
    }

    updateLesson(lessonId, lesson){
        return axios.put(`http://localhost:8080/api/classes/${lessonId}`, lesson)
    }

    deleteLesson(lessonId){
        return axios.delete(`http://localhost:8080/api/classes/${lessonId}`)
    }
    
    addStudentToLesson(lessonId, student){
        return axios.post(`http://localhost:8080/api/classes/${lessonId}/add-student`, student)
    }

    removeStudentFromLesson(lessonId, studentId) {
        return axios.delete(`http://localhost:8080/api/classes/${lessonId}/students/${studentId}`)
    }

    addCoachToLesson(lessonId, coach){
        return axios.post(`http://localhost:8080/api/classes/${lessonId}/add-coach`, coach)
    }

    removeCoachFromLesson(lessonId, coachId) {
        return axios.delete(`http://localhost:8080/api/classes/${lessonId}/coaches/${coachId}`)
    }
}

export default new LessonDataService()