import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';  // Correctly import useNavigate

const DemandsTable = () => {
    const [demands, setDemands] = useState([]);
    const navigate = useNavigate();  // Initialize useNavigate

    useEffect(() => {
        const userId = localStorage.getItem('userId'); // Get user ID from local storage

        const fetchDemands = async () => {
            try {
                const response = await axios.get(`http://localhost:8061/demands?userId=${userId}`);
                setDemands(response.data);
            } catch (error) {
                console.error('Error fetching demands:', error);
            }
        };

        fetchDemands();
    }, []);

    const handleAddDemand = () => {
        navigate('/demandForm');  // Use navigate to redirect
    };

    return (
        <div>
            <h2>Demands List</h2>
            
            <button onClick={handleAddDemand}>Add Demand</button>  {/* Add the button */}
            <table style={{ width: '100%', borderCollapse: 'collapse' }}>
                <thead>
                    <tr style={{ borderBottom: '1px solid #ddd', textAlign: 'left' }}>
                        <th style={{ padding: '8px' }}>ID</th>
                        <th style={{ padding: '8px' }}>Subject</th>
                        <th style={{ padding: '8px' }}>Description</th>
                        <th style={{ padding: '8px' }}>Date</th>
                        <th style={{ padding: '8px' }}>State</th>
                        <th style={{ padding: '8px' }}>Username</th>
                    </tr>
                </thead>
                <tbody>
                    {demands.map((demand) => (
                        <tr key={demand.id}>
                            <td style={{ padding: '8px' }}>{demand.id}</td>
                            <td style={{ padding: '8px' }}>{demand.sujet}</td>
                            <td style={{ padding: '8px' }}>{demand.description}</td>
                            <td style={{ padding: '8px' }}>{demand.date}</td>
                            <td style={{ padding: '8px' }}>{demand.etat}</td>
                            <td style={{ padding: '8px' }}>{demand.user?.username}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
    
};

export default DemandsTable;