import { Sheet, Table } from "@mui/joy";
import React, { useState } from "react";

const TradeHistory = () => {
	const [TradeList, setTradeList] = useState({
		MotifsVirement: "",
		Montant: 0,
		effectDate: 0,
		Status: "",
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
							<th className="w-1/3">Motifs du Virement</th>
							<th>Montant</th>
							<th>Date d'effet</th>
							<th>Status</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>{TradeList.MotifsVirement}</td>
							<td>{TradeList.Montant}</td>
							<td>{TradeList.effectDate}</td>
							<td>{TradeList.Status}</td>
						</tr>
					</tbody>
				</Table>
			</Sheet>
		</div>
	);
};

export default TradeHistory;
