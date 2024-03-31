import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import Login from "./Pages/Login.jsx";
import Home from "./Pages/Home.jsx";
import List from "./Pages/Account/List.jsx";

import "@fontsource/inter";
import "@fontsource/bebas-neue";

ReactDOM.createRoot(document.getElementById("root")).render(
	<React.StrictMode>
		{/* <Login /> */}
		<List />
	</React.StrictMode>
);
