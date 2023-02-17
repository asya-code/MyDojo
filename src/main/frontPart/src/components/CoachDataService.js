import axios from "axios"

class CoachDataService{
    retrieveAllCoaches(){
        console.log("retrieveAllCoaches called")
        return axios.get(`http://localhost:8080/api/coaches/all`)
    }

    retrieveCoach(coachId){
        return axios.get(`http://localhost:8080/api/coaches/${coachId}`)
    }

    addCoach(coach) {
        return axios.post(`http://localhost:8080/api/coaches/registerCoach`, coach)
    }

    updateCoach(coachId, coach){
        return axios.put(`http://localhost:8080/api/coaches/${coachId}`, coach)
    }

    deleteCoach(coachId){
        return axios.delete(`http://localhost:8080/api/coaches/${coachId}`)
    }
    
}

export default new CoachDataService()