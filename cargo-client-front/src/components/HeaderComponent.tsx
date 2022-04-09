import React from "react";
import {useAuth} from "../context/AuthContext";


const HeaderComponent: React.FC = () => {
    const { user,Logout } = useAuth();

        return (
            <div>
                <nav className="navbar navbar-expand-lg navbar-light bg-light">
                    <a style={{marginLeft: "10px"}} className="navbar-brand" href={'/sensors'}>Главная</a>
                    <div style={{marginRight: "10px"}} className="col-4 d-flex justify-content-end align-items-center">
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

                </nav>
            </div>
        )
    }

export default HeaderComponent;
