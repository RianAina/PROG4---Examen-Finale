import React, { useState } from "react";
import "./Login.css";
import {
	Button,
	Checkbox,
	FormControl,
	FormHelperText,
	FormLabel,
	Input,
} from "@mui/joy";
import { useFormik } from "formik";
import * as Yup from "yup";

const Login = () => {
	const [showPassword, setShowPassword] = useState(false);

	const loginForm = useFormik({
		initialValues: {
			email: "",
			password: "",
		},

		validationSchema: Yup.object().shape({
			email: Yup.string()
				.required("Veuillez entrer votre adresse mail")
				.email("Veuillez entrer une adresse mail valide"),
			password: Yup.string().required(
				"Veuillez entre votre mot de passe"
			),
		}),

		onSubmit: (values) => {
			console.log(values);
		},
	});

	return (
		<div className="w-screen h-screen grid place-items-center">
			<div className="bg-white rounded-xl p-1 w-1/2 h-[75vh] grid grid-cols-1 lg:grid-cols-2">
				<div className="rounded-xl bg-blue-300 loginImage relative hidden lg:block">
					<div className="absolute left-4 bottom-4 font-display text-5xl space-y-1">
						<div>Votre</div>
						<div>Portefeuille</div>
						<div>Numérique</div>
					</div>
				</div>
				<div className="flex flex-col p-4 justify-between items-center text-black">
					<div className="text-sm"></div>
					<div className="flex flex-col gap-8 w-2/3">
						<div className="text-center">
							<div className="text-5xl font-display">
								Bienvenue
							</div>
							<div className="text-xs">
								Connectez-vous pour accéder à votre espace
							</div>
						</div>
						<div className="flex flex-col gap-2">
							<FormControl
								error={
									loginForm.touched.email &&
									!!loginForm.errors.email
								}
							>
								<FormLabel>Email</FormLabel>
								<Input
									name="email"
									value={loginForm.values.email}
									onBlur={loginForm.handleBlur}
									onChange={loginForm.handleChange}
									placeholder="Votre adresse mail…"
								/>
								<FormHelperText>
									{loginForm.touched.email &&
									!!loginForm.errors.email
										? loginForm.errors.email
										: ""}
								</FormHelperText>
							</FormControl>
							<FormControl
								error={
									loginForm.touched.password &&
									!!loginForm.errors.password
								}
							>
								<FormLabel>Mot de passe</FormLabel>
								<Input
									name="password"
									type={showPassword ? "text" : "password"}
									value={loginForm.values.password}
									onBlur={loginForm.handleBlur}
									onChange={loginForm.handleChange}
									placeholder="Votre mot de passe…"
								/>
								<FormHelperText>
									{loginForm.touched.password &&
									!!loginForm.errors.password
										? loginForm.errors.password
										: ""}
								</FormHelperText>
							</FormControl>
							<Checkbox
								size="sm"
								checked={showPassword}
								onChange={() =>
									setShowPassword((prev) => !prev)
								}
								label="Afficher le mot de passe"
								className="!-mt-1 !mb-2"
							/>
							<Button onClick={() => loginForm.handleSubmit()}>
								Se connecter
							</Button>
							<div className="underline text-xs cursor-pointer text-center">
								Créer un compte
							</div>
						</div>
						<div></div>
					</div>
					<div className="text-sm"></div>
				</div>
			</div>
		</div>
	);
};

export default Login;
