import { BrowserRouter, Routes, Route, useLocation  } from 'react-router-dom';
import LoginComponent from './Component/LoginComponent';
import './App.css';
import './App.css'

function App() {
  return (
    <BrowserRouter>
      <RouteRender />
    </BrowserRouter>
  );
}
// Nouveau composant pour gérer les routes et les emplacements
function RouteRender() {
  const location = useLocation(); // Correctement placé à l'intérieur du contexte de routeur

  return (
    <>
      
      <div className='App'>
        <Routes>
          <Route path='/' element={<LoginComponent />} />
          
        </Routes>
      </div>
      
    </>
  );

}

export default App
