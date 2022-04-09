import axios from "axios";

const API_AUTH_URL = 'http://localhost:8080/api/auth'

export function executeBasicAuthenticationService(username, password) {
        return axios.post(`${API_AUTH_URL}/signin`, {
                username,
                password
            })
    }

export function isUserLoggedIn() {
        let user = localStorage.getItem('@App:user')
        if (!user) return false
        return true
    }

export function createJWTToken(token) {
    return 'Bearer ' + token
}

