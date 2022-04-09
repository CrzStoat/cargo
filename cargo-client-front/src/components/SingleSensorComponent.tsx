import React, {useState} from "react";
import {getSensorById} from "../services/SensorsService";
import {RouteComponentProps} from 'react-router-dom';

type sensor = {
    id: string,
    value: string,
    registrationDate: string
}

interface RouterProps { // type for `match.params`
    id: string; // must be type `string` since value comes from the URL
}

interface TopicDetailProps extends RouteComponentProps<RouterProps> {
    // any other props (leave empty if none)
}

export const SingleSensorComponent: React.FC<TopicDetailProps> = ({match}) => {
    const [sensor, setSensor] = useState<sensor | null>(null);

        getSensorById( parseInt(match.params.id) ).then(response => {
            setSensor(response.data)
        }).catch(() => {
                alert("Get Error")
                return null
            }
        )

    if (!sensor){
        return <small>loading...</small>
    }

    return (
        <div>
            <h1 className="text-center">Sensor</h1>

            <div className="row row-cols-1 row-cols-md-2 g-4">
                <div className="col">
                    <div className="card">
                        <div className="card-body">
                            <h5 className="card-title">{sensor.id}</h5>
                            <p className="card-body">{sensor.value}</p>
                        </div>
                        <div className="card-footer">
                            <small className="text-muted">
                                {sensor.registrationDate}
                            </small>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )

}
