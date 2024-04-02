import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import Login from "./Pages/Login.jsx";
import Home from "./Pages/Home.jsx";
import AccountList from "./Pages/Account/AccountList.jsx";
import { BrowserRouter as Router, Link, Route, Routes } from "react-router-dom";

import "@fontsource/inter";
import "@fontsource/inter/latin-700.css";
import "@fontsource/bebas-neue";
import WithdrawForm from "./Pages/MoneyWithdraw/WithdrawForm.jsx";
import EditInterestRate from "./Pages/InterestRate/EditInterestRate.jsx";
import ViewBalance from "./Pages/Balance/ViewBalance.jsx";
import AccountHistory from "./Pages/history/AccountHistory.jsx";
import TradeHistory from "./Pages/trade/TradeHistory.jsx";
import CategorisedTransfert from "./Pages/Category/CategorisingTransfert.jsx";
import Layout from "./Layout/Layout.jsx";

ReactDOM.createRoot(document.getElementById("root")).render(
	<React.StrictMode>
		<Router>
			{" "}
			interets
			<Layout>
				<Routes>
					<Route index path="/" element={<AccountList />} />

					<Route path="/soldes" element={<ViewBalance />} />

					<Route path="/interets" element={<EditInterestRate />} />

					<Route path="/retrait" element={<WithdrawForm />} />

					<Route path="/virements" element={<EditInterestRate />} />

					<Route path="/releve" element={<TradeHistory />} />

					<Route
						path="/categorie"
						element={<CategorisedTransfert />}
					/>
				</Routes>
			</Layout>
		</Router>
	</React.StrictMode>
);
