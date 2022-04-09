import React from "react";
import {useAuth} from "../context/AuthContext";


const HeaderComponent: React.FC = () => {
    const { user,Logout } = useAuth();

        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <a className="navbar-brand" href={'/sensors'}>Главная</a>
                    <div className="col-4 d-flex justify-content-end align-items-center">
                        { user ?
                            <div>
                                <span>{user.username} </span>
                            <button className="btn btn-sm btn-outline-secondary"
                               onClick={Logout}> LogOut </button>
                            </div>
                            :
                            <a className="btn btn-sm btn-outline-secondary" href='/login'>LogIn</a>
                        }
                    </div>
                    <button className="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"/>
                    </button>


                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item">
                                <a className="nav-link" href={'/sensors'}></a>
                            </li>
                            <li className="nav-item dropdown">
                                <a className="nav-link dropdown-toggle" href={'/sensors'} id="navbarDropdown" role="button"
                                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Сервисы
                                </a>
                                <div className="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a className="dropdown-item" href={'/sensors'}>Action</a>
                                    <a className="dropdown-item" href={'/sensors'}>Another action</a>
                                    <div className="dropdown-divider"/>
                                    <a className="dropdown-item" href={'/sensors'}>Something else here</a>
                                </div>
                            </li>
                        </ul>

                    </div>
                </nav>
            </div>
        )
    }

export default HeaderComponent;
