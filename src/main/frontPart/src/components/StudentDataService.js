import axios from "axios"

class StudentDataService{
    retrieveAllStudents(){
        console.log("retrieveAllStudents called")
        return axios.get(`http://localhost:8080/api/students`)
    }

    retrieveStudent(studentId){
        return axios.get(`http://localhost:8080/api/students/${studentId}`)
    }

    addStudent(student) {
        return axios.post(`http://localhost:8080/api/students`, student)
    }

    updateStudent(studentId, student){
        return axios.put(`http://localhost:8080/api/students/${studentId}`, student)
    }

    deleteStudent(studentId){
        return axios.delete(`http://localhost:8080/api/students/${studentId}`)
    }
    
}

export default new StudentDataService()