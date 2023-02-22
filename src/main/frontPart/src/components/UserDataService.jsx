import axios from "axios"

class UserDataService{
    retrieveAllUsers(){
        console.log("retrieveAllUsers called")
        return axios.get(`http://localhost:8080/api/users/all`)
    }

    userLogin(session, user){
        return axios.post(`http://localhost:8080/api/users/login`)
    }

    retrieveUser(email){
        return axios.get(`http://localhost:8080/api/users/${email}`)
    }
    registerUser(email, password){
        return axios.post(`http://localhost:8080/api/users/register`)
    }
    
}

export default new UserDataService()