import {
	Button,
	DialogTitle,
	FormControl,
	FormLabel,
	Input,
	List,
	Modal,
	ModalClose,
	ModalDialog,
	Option,
	Select,
	Sheet,
} from "@mui/joy";
import React, { useState } from "react";

const WithdrawForm = () => {
	const [accountList, setAccountList] = useState([
		{
			id: 1,
			nom: "Dupont",
			prenoms: "Marie Jeanne",
			date_de_naissance: "1985-07-15",
			salaire_mensuel_net: 3500,
			numero_compte: "FR7612345678901234567890123",
			solde: 1000000,
			allowCredit: false,
		},
		{
			id: 2,
			nom: "Leroy",
			prenoms: "Pierre Luc",
			date_de_naissance: "1992-03-22",
			salaire_mensuel_net: 4200,
			numero_compte: "FR7698765432109876543210",
			solde: 500000,
			allowCredit: false,
		},
		{
			id: 3,
			nom: "Garcia",
			prenoms: "Laura Sophie",
			date_de_naissance: "1988-11-05",
			salaire_mensuel_net: 5100,
			numero_compte: "FR7612349876543210987654",
			solde: 700000,
			allowCredit: false,
		},
		{
			id: 4,
			nom: "Lemaire",
			prenoms: "Paul Antoine",
			date_de_naissance: "1979-04-28",
			salaire_mensuel_net: 6200,
			numero_compte: "FR7687654321098765432109",
			solde: 1500000,
			allowCredit: true,
		},
		{
			id: 5,
			nom: "Mercier",
			prenoms: "Juliette Emma",
			date_de_naissance: "1995-09-12",
			salaire_mensuel_net: 3000,
			numero_compte: "FR7643215678909876543210",
			solde: 900000,
			allowCredit: false,
		},
	]);
	const [showResult, setShowResult] = useState(false);
	const [withdrawError, setWithdrawError] = useState(true);
	const [formValue, setFormValue] = useState({
		date: "",
		hour: "",
		account: null,
		amount: 0,
	});

	const handleChange = (e) => {
		setFormValue((prev) => ({ ...prev, [e.target.name]: e.target.value }));
	};

	const handleSubmit = () => {
		const selectedAccount = accountList.find(
			(acc) => acc.id === formValue.account
		);
		const creditAmount = selectedAccount.allowCredit
			? selectedAccount.salaire_mensuel_net / 3
			: 0;

		const allowWithdraw =
			formValue.amount <
			selectedAccount.solde + selectedAccount.solde + creditAmount;

		setWithdrawError(!allowWithdraw);
		setShowResult(true);
	};

	return (
		<>
			{!!showResult && (
				<Modal open={!!showResult} onClose={() => setShowResult(false)}>
					<ModalDialog
						color={withdrawError ? "danger" : "success"}
						sx={{ minWidth: "30vw" }}
					>
						<ModalClose />
						<DialogTitle>
							{withdrawError
								? "Retrait non autorisé"
								: "Retrait effectué avec succès"}
						</DialogTitle>
					</ModalDialog>
				</Modal>
			)}
			<div>
				<Sheet sx={{ p: 4 }}>
					<div className="grid grid-cols-2 gap-4">
						<FormControl>
							<FormLabel>Compte</FormLabel>
							<Select
								name="account"
								value={formValue.account}
								onChange={(e, newValue) =>
									setFormValue((prev) => ({
										...prev,
										account: newValue,
									}))
								}
							>
								{accountList.map((account) => (
									<Option
										value={account.id}
										key={account.id}
									>{`${account.nom} ${account.prenoms}`}</Option>
								))}
							</Select>
						</FormControl>
						<FormControl>
							<FormLabel>Montant</FormLabel>
							<Input
								name="amount"
								type="number"
								value={formValue.amount}
								onChange={(e) => handleChange(e)}
							/>
						</FormControl>
						<FormControl>
							<FormLabel>Date</FormLabel>
							<Input
								name="date"
								type="date"
								variant="solid"
								value={formValue.date}
								onChange={(e) => handleChange(e)}
							/>
						</FormControl>
						<FormControl>
							<FormLabel>Heure</FormLabel>
							<Input
								name="hour"
								type="time"
								variant="solid"
								value={formValue.hour}
								onChange={(e) => handleChange(e)}
							/>
						</FormControl>
						<div className="col-span-2 grid place-items-center">
							<Button onClick={handleSubmit}>Enregistrer</Button>
						</div>
					</div>
				</Sheet>
			</div>
		</>
	);
};

export default WithdrawForm;
