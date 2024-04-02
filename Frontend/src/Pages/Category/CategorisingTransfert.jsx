import { Button, Option, Select, Sheet, Table } from "@mui/joy";
import React, { useState } from "react";
import EditIcon from "@mui/icons-material/Edit";

const CategorisedTransfert = () => {
	const [categories, setCategories] = useState([
		{
			id: 1,
			name: "Food and Drinks",
		},
		{
			id: 2,
			name: "Shopping",
		},
		{
			id: 3,
			name: "Housing",
		},
		{
			id: 4,
			name: "Transportation",
		},
		{
			id: 5,
			name: "Vehicle",
		},
		{
			id: 6,
			name: "Life and entertainement",
		},
		{
			id: 7,
			name: "Communication",
		},
		{
			id: 8,
			name: "Financial expenses",
		},
		{
			id: 9,
			name: "investisments",
		},
		{
			id: 10,
			name: "Income",
		},
		{
			id: 11,
			name: "Others",
		},
	]);
	const [transfertList, setTransfertList] = useState([
		{
			id: 1,
			reference: "Virement",
			motifs: "billet concert",
			montant: 20000,
			categorie: null,
		},
		{
			id: 2,
			reference: "Virement",
			motifs: "achat voiture",
			montant: 3000000,
			categorie: null,
		},
		{
			id: 3,
			reference: "Virement",
			motifs: " location maison",
			montant: 200000,
			categorie: null,
		},
	]);

	const updateTransfert = (transferId, categoryId) => {
		let tempTransfertList = [...transfertList];

		let transfert = tempTransfertList.find((t) => t.id == transferId);
		transfert.categorie = categoryId;
		setTransfertList(tempTransfertList);
	};

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
							<th className="w-1/3">Reference</th>
							<th>motif</th>
							<th>montant</th>
							<th>Categorie</th>
							<th>action</th>
						</tr>
					</thead>
					<tbody>
						{transfertList.map((transfert) => (
							<Transfert
								key={transfert.id}
								transfert={transfert}
								categories={categories}
								updateTransfert={updateTransfert}
							/>
						))}
					</tbody>
				</Table>
			</Sheet>
		</div>
	);
};

const Transfert = ({ transfert, categories, updateTransfert }) => {
	const [changeCategory, setChangeCategory] = useState(false);
	const [categoryId, setCategoryId] = useState(transfert.categorie);

	return (
		<tr>
			<td>{transfert.reference}</td>
			<td>{transfert.motifs}</td>
			<td>{transfert.montant}</td>
			<td>
				{categories.find((c) => c.id == transfert.categorie)?.name ??
					"-"}
			</td>
			<td>
				{changeCategory ? (
					<div>
						<Select
							value={categoryId}
							onChange={(e, newValue) => setCategoryId(newValue)}
						>
							{categories.map((category) => (
								<Option value={category.id} key={category.id}>
									{category.name}
								</Option>
							))}
						</Select>
						<Button
							variant="soft"
							color="primary"
							onClick={() => {
								updateTransfert(transfert.id, categoryId);
								setChangeCategory(false);
							}}
						>
							Valider
						</Button>
					</div>
				) : (
					<Button
						variant="soft"
						color="warning"
						startDecorator={<EditIcon />}
						onClick={() => setChangeCategory(true)}
					>
						ajout catégorie
					</Button>
				)}
			</td>
		</tr>
	);
};

export default CategorisedTransfert;
