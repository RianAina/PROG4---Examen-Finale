import { Sheet, Table } from "@mui/joy";
import React, { useState } from "react";

const AccountHistory = () => {
	const [AllHistory, setAllHistory] = useState({
		reference: 0,
		Motifs: 0,
		creditMGA: 0,
		debitMGA: 0,
		solde: 0,
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
							<th>Date</th>
							<th>reference</th>
							<th>Motifs</th>
							<th>credit MGA</th>
							<th>debit MGA</th>
							<th className="w-1/3">solde</th>
						</tr>
					</thead>
					<tbody>
						{AllHistory.map((History) => (
							<tr>
								<td>
									{new Date().toLocaleString("fr-FR", {
										dateStyle: "long",
									})}
								</td>
								<td>{History.reference}</td>
								<td>{History.Motifs}</td>
								<td>{History.creditMGA}</td>
								<td>{History.debitMGA}</td>
								<td>{History.solde}</td>
							</tr>
						))}
					</tbody>
				</Table>
			</Sheet>
		</div>
	);
};

export default AccountHistory;
