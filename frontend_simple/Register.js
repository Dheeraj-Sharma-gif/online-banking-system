import React, { useState } from 'react';

export default function Register() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`Registering user: ${name}`);
  };

  return (
    <div style={{maxWidth: '400px', margin: 'auto', marginTop: '50px'}}>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Name"
          value={name}
          onChange={e => setName(e.target.value)}
          required
          style={{width: '100%', padding: '8px', marginBottom: '10px'}}
        />
        <input
          type="email"
          placeholder="Email"
          value={email}
          onChange={e => setEmail(e.target.value)}
          required
          style={{width: '100%', padding: '8px', marginBottom: '10px'}}
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={e => setPassword(e.target.value)}
          required
          style={{width: '100%', padding: '8px', marginBottom: '10px'}}
        />
        <button type="submit" style={{width: '100%', padding: '10px'}}>Register</button>
      </form>
    </div>
  );
}
