import {
	Button,
	DialogTitle,
	List,
	ListItem,
	Modal,
	ModalClose,
	ModalDialog,
	Sheet,
	Table,
} from "@mui/joy";
import React, { useState } from "react";
import EditIcon from "@mui/icons-material/Edit";
import EditAccount from "./EditAccount";

const AccountList = () => {
	const [selectedAccount, setSelectedAccount] = useState(null);
	const [accountList, setAccountList] = useState([
		{
			id: 1,
			nom: "Dupont",
			prenoms: "Marie Jeanne",
			date_de_naissance: "1985-07-15",
			salaire_mensuel_net: 3500,
			numero_compte: "FR7612345678901234567890123",
		},
		{
			id: 2,
			nom: "Leroy",
			prenoms: "Pierre Luc",
			date_de_naissance: "1992-03-22",
			salaire_mensuel_net: 4200,
			numero_compte: "FR7698765432109876543210",
		},
		{
			id: 3,
			nom: "Garcia",
			prenoms: "Laura Sophie",
			date_de_naissance: "1988-11-05",
			salaire_mensuel_net: 5100,
			numero_compte: "FR7612349876543210987654",
		},
		{
			id: 4,
			nom: "Lemaire",
			prenoms: "Paul Antoine",
			date_de_naissance: "1979-04-28",
			salaire_mensuel_net: 6200,
			numero_compte: "FR7687654321098765432109",
		},
		{
			id: 5,
			nom: "Mercier",
			prenoms: "Juliette Emma",
			date_de_naissance: "1995-09-12",
			salaire_mensuel_net: 3000,
			numero_compte: "FR7643215678909876543210",
		},
	]);

	const updateList = (newAccount) => {
		const currentList = accountList.filter(
			(account) => account.id !== newAccount.id
		);
		setAccountList([...currentList, newAccount]);
		setSelectedAccount(null);
	};

	return (
		<>
			{!!selectedAccount && (
				<Modal
					open={!!selectedAccount}
					onClose={() => setSelectedAccount(null)}
				>
					<ModalDialog>
						<ModalClose />
						<DialogTitle>Modifier un compte</DialogTitle>
						<List
							sx={{
								mx: "calc(-1 * var(--ModalDialog-padding))",
								px: "var(--ModalDialog-padding)",
							}}
						>
							<EditAccount
								account={selectedAccount}
								updateList={updateList}
							/>
						</List>
					</ModalDialog>
				</Modal>
			)}
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
								<th className="w-1/3">Nom</th>
								<th>Prénoms</th>
								<th>Date de naissance</th>
								<th>Salaire mensuel net</th>
								<th className="w-1/3">
									Numéro de compte unique
								</th>
								<th className="text-center">Actions</th>
							</tr>
						</thead>
						<tbody>
							{accountList.map((account) => (
								<tr key={account.id}>
									<td>{account.nom}</td>
									<td>{account.prenoms}</td>
									<td>{account.date_de_naissance}</td>
									<td>{account.salaire_mensuel_net}</td>
									<td>{account.numero_compte}</td>
									<td>
										<Button
											variant="soft"
											color="warning"
											startDecorator={<EditIcon />}
											onClick={() =>
												setSelectedAccount(account)
											}
										>
											Modifier
										</Button>
									</td>
								</tr>
							))}
						</tbody>
					</Table>
				</Sheet>
			</div>
		</>
	);
};

export default AccountList;
