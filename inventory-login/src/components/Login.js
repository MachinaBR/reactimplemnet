import { useState } from "react";

export default function Login() {
    const [username, setUsername]   = useState("");
    const [password, setPassword]   = useState("");
    const [error, setError]         = useState("");
    const [loading, setLoading]     = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        setError("");
        setLoading(true);

        try {
            const res = await fetch("/login", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                credentials: 'include',
                body: JSON.stringify({ username, password })
            });

            const data = await res.json();
            if (data.success) {
                window.location.href = "/dashboard.html";
            } else {
                setError(data.message);
            }
        } catch {
            setError("Error de conexión");
        } finally {
            setLoading(false);
        }
    };

    return (
        <form onSubmit={handleSubmit} style={{ maxWidth: 320, margin: "0 auto" }}>
            <h2>Iniciar Sesión</h2>

            <div style={{ marginBottom: 12 }}>
                <label>Usuario</label><br/>
                <input
                    type="text"
                    value={username}
                    onChange={e => setUsername(e.target.value)}
                    required
                    style={{ width: "100%" }}
                />
            </div>

            <div style={{ marginBottom: 12 }}>
                <label>Contraseña</label><br/>
                <input
                    type="password"
                    value={password}
                    onChange={e => setPassword(e.target.value)}
                    required
                    style={{ width: "100%" }}
                />
            </div>

            {error && <p style={{ color: "red" }}>{error}</p>}

            <button type="submit" disabled={loading}>
                {loading ? "Cargando..." : "Entrar"}
            </button>
        </form>
    );
}