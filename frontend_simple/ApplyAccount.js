import React, { useState } from 'react';

export default function ApplyAccount() {
  const [fullName, setFullName] = useState('');
  const [aadharNumber, setAadharNumber] = useState('');
  const [panNumber, setPanNumber] = useState('');
  const [accountType, setAccountType] = useState('Savings');
  const [status, setStatus] = useState(null);

  const handleSubmit = (e) => {
    e.preventDefault();

    // Simple validation example
    if (!fullName || !aadharNumber || !panNumber) {
      alert('Please fill all fields');
      return;
    }

    // Simulate backend review & approval
    if (aadharNumber.length === 12 && panNumber.length === 10) {
      setStatus('Application Approved! Account created.');
    } else {
      setStatus('Application Rejected! Invalid Aadhar or PAN.');
    }
  };

  return (
    <div style={{maxWidth: '400px', margin: 'auto', marginTop: '50px'}}>
      <h2>Apply for New Account</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Full Name"
          value={fullName}
          onChange={e => setFullName(e.target.value)}
          required
          style={{width: '100%', padding: '8px', marginBottom: '10px'}}
        />
        <input
          type="text"
          placeholder="Aadhar Number"
          value={aadharNumber}
          onChange={e => setAadharNumber(e.target.value)}
          required
          maxLength="12"
          style={{width: '100%', padding: '8px', marginBottom: '10px'}}
        />
        <input
          type="text"
          placeholder="PAN Number"
          value={panNumber}
          onChange={e => setPanNumber(e.target.value)}
          required
          maxLength="10"
          style={{width: '100%', padding: '8px', marginBottom: '10px'}}
        />
        <select
          value={accountType}
          onChange={e => setAccountType(e.target.value)}
          style={{width: '100%', padding: '8px', marginBottom: '10px'}}
        >
          <option value="Savings">Savings</option>
          <option value="Current">Current</option>
        </select>
        <button type="submit" style={{width: '100%', padding: '10px'}}>Submit Application</button>
      </form>
      {status && <p style={{marginTop: '20px'}}>{status}</p>}
    </div>
  );
}
