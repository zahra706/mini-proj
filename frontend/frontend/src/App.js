import React from 'react';
import Favorites from './Favorites';
import Recommendations from './Recommendations';
function App() {
    return (
        <div>
            <h1>Online Training Platform</h1>
            <Favorites />
            <Recommendations />
        </div>
    );
}
export default App;