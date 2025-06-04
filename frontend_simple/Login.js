import React, { useState } from 'react';

export default function Login() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`Logging in with email: ${email}`);
  };

  return (
    <div style={{maxWidth: '400px', margin: 'auto', marginTop: '50px'}}>
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
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
        <button type="submit" style={{width: '100%', padding: '10px'}}>Login</button>
      </form>
    </div>
  );
}
