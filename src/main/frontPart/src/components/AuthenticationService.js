import axios from 'axios';

class AuthenticationService {
    // executeBasicAuthenticationService(username, password) {
    //     return axios.get(`${API_URL}/basicauth`,
    //         { headers: { authorization: this.createBasicAuthToken(username, password) } })
    // }

    // createBasicAuthToken(username, password) {
    //     return 'Basic ' + window.btoa(username + ":" + password)
    // }

    // registerSuccessfulLogin(username, password){
    //     console.log('registerSuccessfulLogin')
    //     sessionStorage.setItem('authenticatedUser', username);
    //     this.setupAxiosInterceptors(this.createBasicAuthToken(username, password))

    // }

    registerSuccessfulLogin(username, password){
        sessionStorage.setItem('authenticatedUser', username)
    }

    logout(){
        sessionStorage.removeItem('authenticatedUser');
    }

    isUserLoggedIn(){
        let user = sessionStorage.getItem('authenticatedUser');
        if (user == null) return false;
        return true
    }

    getLoggedInUserName(){
        let user = sessionStorage.getItem('authenticatedUser');
        if (user == null) return '';
        return user
    }

    // setupAxiosInterseptors(){
    //     axios.interceptor.request.use(
    //      (config) => {
    //         if (this.isUserLoggedIn()) {
    //             config.headers.authorization = token
    //         }
    //         return config
    //      }   
    //     )
    // }
}

export default new AuthenticationService()