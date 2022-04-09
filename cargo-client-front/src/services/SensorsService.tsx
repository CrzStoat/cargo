import axios from "axios";

const SENSORS_REST_API_URL = 'http://localhost:8080/api/sensors-info';
const DEFAULT_PAGE = 0;
const DEFAULT_PAGE_SIZE = 10;


type sensor = {
    id: string,
    value: string,
    registrationDate: string
}

export function getAllSensors(){
       return  getSensorsByPage(DEFAULT_PAGE_SIZE, DEFAULT_PAGE);
    }

export function getSensorById(sensorId: number){
    const resp = axios.get<sensor>(SENSORS_REST_API_URL + "/get/" + sensorId, {
            headers: {authorization: localStorage.getItem('@App:token')}
        });
        return  resp
    }

export function getSensorsByPage(pageSize: number, page: number){
    const resp = axios.get<sensor[]>(SENSORS_REST_API_URL + "/get", {
        headers: {authorization: localStorage.getItem('@App:token')},
        params: {
            page: page,
            page_size: pageSize
        }
    });
    return resp
}


