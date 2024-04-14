import React, { useState } from 'react';

const LoginComponent = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    

    const handleLogin = (e) => {
        e.preventDefault();
        if (username === 'admin' && password === '123AZEQSD') {
            console.log('hello');
            alert('Sallut administrator');
        } else {
            alert('Invalid credentials');
        }
        // ici on va ajouter login selon la base de donnees (table user ) pour que les utilisteurs puissent entrer remplir formulaire + voir les demandes et leurs etats 
    };

    return (
        <div className='container'>
            <div className='row '>
                <div className='col'>
                    <div className='card'>
                        <div className='card-body'>
                            <form onSubmit={handleLogin} >
                                <div className='col' >
                                    
                                    <input
                                        type="text"
                                        className='col-sm-2 col-form-label col-form-label-sm'
                                        value={username}
                                        onChange={(e) => setUsername(e.target.value)}
                                        required
                                        placeholder='Nom'
                                    />
                                </div>
                                <div className='col'>
                                    <input
                                        type="password"
                                        className='form-control'
                                        value={password}
                                        onChange={(e) => setPassword(e.target.value)}
                                        required
                                        placeholder='Password'
                                    />
                                </div>
                                <button type='submit' className='btn btn-light'>
                                    Login
                                </button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default LoginComponent;
