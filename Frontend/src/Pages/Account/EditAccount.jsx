import {
	Button,
	FormControl,
	FormHelperText,
	FormLabel,
	Input,
} from "@mui/joy";
import React, { useState } from "react";

const EditAccount = ({ account, updateList }) => {
	const [formValue, setFormValue] = useState(account);

	const handleChange = (e) => {
		setFormValue((prev) => ({ ...prev, [e.target.name]: e.target.value }));
	};

	const handleSubmit = () => {
		updateList(formValue);
	};

	return (
		<div className="grid grid-cols-2 gap-4">
			<FormControl>
				<FormLabel>Nom</FormLabel>
				<Input
					name="nom"
					value={formValue.nom}
					onChange={(e) => handleChange(e)}
					placeholder="Nom"
				/>
			</FormControl>
			<FormControl>
				<FormLabel>Prénoms</FormLabel>
				<Input
					name="prenoms"
					value={formValue.prenoms}
					onChange={(e) => handleChange(e)}
					placeholder="Prénoms"
				/>
			</FormControl>
			<FormControl>
				<FormLabel>Date de naissance</FormLabel>
				<Input
					variant="solid"
					name="date_de_naissance"
					type="date"
					value={formValue.date_de_naissance}
					onChange={(e) => handleChange(e)}
					placeholder="Date de naissance"
				/>
			</FormControl>
			<FormControl>
				<FormLabel>Salaire mensuel net</FormLabel>
				<Input
					name="salaire_mensuel_net"
					value={formValue.salaire_mensuel_net}
					onChange={(e) => handleChange(e)}
					placeholder="Salaire mensuel net"
				/>
			</FormControl>
			<div className="col-span-2 grid place-items-center">
				<Button onClick={handleSubmit}>Enregistrer</Button>
			</div>
		</div>
	);
};

export default EditAccount;
