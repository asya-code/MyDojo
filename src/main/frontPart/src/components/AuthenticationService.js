import axios from 'axios';

class AuthenticationService {
    createBasicAuthToken(username, password) {
        return 'Basic ' + window.btoa(username + ":" + password)
    }

    registerSuccessfulLogin(username, password){
        console.log('registerSuccessfulLogin')
        sessionStorage.setItem('authenticatedUser', username);
        this.setupAxiosInterceptors(this.createBasicAuthToken(username, password))

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

    setupAxiosInterseptors(){
        axios.interceptor.request.use(
         (config) => {
            if (this.isUserLoggedIn()) {
                config.headers.authorization = token
            }
            return config
         }   
        )
    }
}

export default new AuthenticationService()