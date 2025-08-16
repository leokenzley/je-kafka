'use client'; // ⚠️ obrigatório para usar useState

import { useState } from 'react';

export default function Home() {
  const [message, setMessage] = useState('');
  const [status, setStatus] = useState<string | null>(null);

  const handleSendMessage = async () => {
    try {
      const response = await fetch('http://localhost:8081/producer', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({ message })
      });

      if (response.ok) {
        setStatus('Enviado com sucesso');
      } else {
        setStatus('Erro ao enviar a mensagem');
      }
    } catch (error) {
      console.error(error);
      setStatus('Erro ao enviar a mensagem');
    }
  };

  return (
    <div style={{ padding: '2rem', maxWidth: '600px', margin: '0 auto', border: '1px solid #ccc', borderRadius: '8px' }}>
      <h1>Enviar Mensagem</h1>
      <textarea
        rows={5}
        style={{ width: '100%', marginBottom: '1rem' }}
        value={message}
        onChange={(e) => setMessage(e.target.value)}
      />
      <br />
      <button onClick={handleSendMessage}>Enviar</button>
      {status && <p>{status}</p>}
    </div>
  );
}
