import { Sheet, Table } from "@mui/joy";
import React, { useState } from "react";

const ViewBalance = () => {
	const [balanceInfo, setbalanceInfo] = useState({
		balance: 0,
		loan: 0,
		interestRate: 0,
	});

	return (
		<div className="p-4">
			<Sheet sx={{ borderRadius: 8, overflow: "auto" }}>
				<Table
					borderAxis="yBetween"
					color="neutral"
					size="md"
					stickyFooter={false}
					stickyHeader
					variant="soft"
					sx={{
						width: "auto",
						minWidth: "100%",
						whiteSpace: "break-spaces",
					}}
				>
					<thead>
						<tr>
							<th className="w-1/3">Date</th>
							<th>Solde</th>
							<th>Prêts</th>
							<th>Intérêt des prêts</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								{new Date().toLocaleString("fr-FR", {
									dateStyle: "long",
								})}
							</td>
							<td>{balanceInfo.balance}</td>
							<td>{balanceInfo.loan}</td>
							<td>{balanceInfo.interestRate}%</td>
						</tr>
					</tbody>
				</Table>
			</Sheet>
		</div>
	);
};

export default ViewBalance;
