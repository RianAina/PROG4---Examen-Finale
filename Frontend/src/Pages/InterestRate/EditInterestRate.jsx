import { Button, FormControl, FormLabel, Input, Sheet } from "@mui/joy";
import React, { useState } from "react";

const EditInterestRate = () => {
	const [formValue, setFormValue] = useState({
		before: 0,
		after: 0,
		threshold: 7,
	});

	const handleChange = (e) => {
		setFormValue((prev) => ({ ...prev, [e.target.name]: e.target.value }));
	};

	const handleSubmit = () => {
		console.log(formValue);
	};

	return (
		<div>
			<Sheet sx={{ p: 4 }}>
				<div className="grid grid-cols-2 gap-4">
					<FormControl>
						<FormLabel>
							Intérêt pendant les 7 premiers jours
						</FormLabel>
						<Input
							name="before"
							type="number"
							value={formValue.before}
							onChange={(e) => handleChange(e)}
							endDecorator={"%"}
						/>
					</FormControl>
					<FormControl>
						<FormLabel>
							Intérêt après les 7 premiers jours
						</FormLabel>
						<Input
							name="after"
							type="number"
							value={formValue.after}
							onChange={(e) => handleChange(e)}
							endDecorator={"%"}
						/>
					</FormControl>
					<div className="col-span-2 grid place-items-center">
						<Button onClick={handleSubmit}>Enregistrer</Button>
					</div>
				</div>
			</Sheet>
		</div>
	);
};

export default EditInterestRate;
