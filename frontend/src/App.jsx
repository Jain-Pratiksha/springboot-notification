import {  useState } from "react";
import axios from "axios";

function App() {
  const [notifications, setNotifications] = useState([]);
  const [message, setMessage] = useState("");
  const [loading, setLoading] = useState(false);

  const API = "http://localhost:8080";


  const fetchNotifications = async () => {
    try {
      const res = await axios.get(`${API}/notify/v1/process`);
      setNotifications(res.data);
    } catch (err) {
      console.error("Error fetching:", err);
    }
  };

  const sendNotification = async () => {
    if (!message.trim()) return;

    setLoading(true);
    try {
      await axios.post(`${API}/send`, { message });
      setMessage("");
      fetchNotifications();
    } catch (err) {
      console.error("Error sending:", err);
    }
    setLoading(false);
  };

  
  return (
    <div className="min-h-screen bg-gray-900 text-white flex flex-col items-center px-4 py-10">

      {/* Header */}
      <div className="max-w-2xl w-full text-center mb-10">
        <h1 className="text-3xl font-bold">🔔 Notification System</h1>
        <p className="text-gray-400 mt-2">
          Real-time Notification System
        </p>
      </div>

      {/* Input */}
      <div className="w-full max-w-2xl bg-gray-800 p-5 rounded-2xl shadow-lg mb-6">
        <div className="flex gap-3">
          <input
            type="text"
            placeholder="Enter message..."
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            onKeyDown={(e) => e.key === "Enter" && sendNotification()}
            className="flex-1 px-4 py-2 rounded-lg bg-gray-700 text-white focus:outline-none focus:ring-2 focus:ring-blue-500"
          />

          <button
            onClick={sendNotification}
            disabled={loading}
            className="bg-blue-600 hover:bg-blue-700 px-5 py-2 rounded-lg font-medium transition disabled:opacity-50"
          >
            {loading ? "Sending..." : "Send"}
          </button>
        </div>
      </div>

      {/* Notifications */}
      <div className="w-full max-w-2xl space-y-4">
        {notifications.length === 0 ? (
          <p className="text-gray-400 text-center">
            No notifications yet 🚀
          </p>
        ) : (
          notifications.map((n, index) => (
            <div
              key={index}
              className="bg-gray-800 p-4 rounded-xl shadow-md hover:scale-[1.01] transition"
            >
              <p>{n.message}</p>
              <p className="text-xs text-gray-400 mt-2">
                {new Date().toLocaleString()}
              </p>
            </div>
          ))
        )}
      </div>
    </div>
  );
}

export default App;