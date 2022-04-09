import React, {createContext, useContext, useEffect, useState} from 'react';

type user = {
    username: string | null,
    token: string | null
}

interface AuthContextData {
    signed: boolean
    user: user | null
    Login(user: object): Promise<void>
    Logout(): void
}

export const AuthContext = createContext<AuthContextData>({} as AuthContextData);
export  default  AuthContext

export const AuthProvider: React.FC = ({ children }) => {
    const [user, setUser] = useState<user | null>(null)

    useEffect(() => {
        const storedUser = localStorage.getItem('@App:user')
        const storedToken = localStorage.getItem('@App:token')

        if (storedToken && storedUser) {
            setUser({
                username: storedUser,
                token: storedToken
            });
        }
    }, []);

    async function Login(user: user) {
        setUser(user)
        if (typeof user.username === "string") {
            localStorage.setItem('@App:user', user.username)
        }
        if (typeof user.token === "string") {
            localStorage.setItem('@App:token', user.token)
        }
    }

    function Logout() {
        setUser(null)
        localStorage.removeItem('@App:user')
        localStorage.removeItem('@App:token')
    }

    return (
        <AuthContext.Provider
            value={{ signed: Boolean(user), user, Login, Logout }}
        >
            {children}
        </AuthContext.Provider>
    )
}

export function useAuth() {
    const context = useContext(AuthContext)

    return context
}
