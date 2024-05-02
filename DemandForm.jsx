import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

function DemandForm() {
    const [sujet, setSujet] = useState('');
    const [description, setDescription] = useState('');
    const [date, setDate] = useState('');
    const formStyle = {
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        padding: '20px',
        margin: '20px',
        border: '1px solid #ccc',
        borderRadius: '5px'
    };

    const inputStyle = {
        margin: '10px 0',
        padding: '10px',
        width: '300px', // Vous pouvez ajuster la largeur comme vous voulez
        borderRadius: '4px',
        border: '1px solid #ccc'
    };

    const labelStyle = {
        fontWeight: 'bold'
    };

    const buttonStyle = {
        padding: '10px 15px',
        borderRadius: '5px',
        border: 'none',
        backgroundColor: '#007bff',
        color: 'white',
        cursor: 'pointer'
    };
    const userId = localStorage.getItem('userId'); // Assurez-vous que l'ID est bien stocké lors de la connexion
    const handleSubmit = async (event) => {
        event.preventDefault();
        const demandData = { sujet, description, date, userId };

        // Fetch API to submit the data
        try {
            const response = await fetch(`http://localhost:8061/demands?userId=${userId}`, {  // Assurez-vous que l'URL est correcte
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(demandData),
            });

            if (response.ok) {
                console.log('Demand submitted successfully');
                
                window.location.reload();
                // Redirection or update UI
            } else {
                console.error('Failed to submit demand');
                // Handle errors
            }
        } catch (error) {
            console.error('Error submitting demand:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit} style={formStyle} >
            <div style={{ display: 'none' }}>
                <input
                    type="text"
                    value={userId}
                    readOnly
                />
            </div>
            <div>
                <label htmlFor="sujet" style={labelStyle}>Subject:</label>
                <input
                    style={inputStyle}
                    type="text"
                    id="sujet"
                    value={sujet}
                    onChange={e => setSujet(e.target.value)}
                    required
                />
            </div>
            <div>
                <label htmlFor="description" style={labelStyle}>Description:</label>
                <textarea
                    style={inputStyle}
                    id="description"
                    value={description}
                    onChange={e => setDescription(e.target.value)}
                    required
                />
            </div>
            <div>
                <label htmlFor="date" style={labelStyle}>Date:</label>
                <input
                    style={inputStyle}
                    type="date"
                    id="date"
                    value={date}
                    onChange={e => setDate(e.target.value)}
                    required
                />
            </div>
            <button type="submit" style={buttonStyle}>Submit Demand</button>
        </form>
    );
}

export default DemandForm;