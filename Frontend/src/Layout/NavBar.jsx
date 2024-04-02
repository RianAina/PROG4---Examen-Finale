import React from "react";
import { Link } from "react-router-dom";
const NavBar = () => {
	return (
		<nav className="bg-gray-800 p-4">
			<div className="w-full px-8">
				<div className="flex justify-between items-center">
					<div className="flex-shrink-0 text-white">
						{/* Logo */}
						<span className="font-semibold text-xl">Wallet</span>
					</div>
					<div className="hidden md:block">
						<ul className="flex space-x-20">
							<li>
								<Link
									to="/"
									className="text-white hover:text-gray-300"
								>
									Comptes
								</Link>
							</li>
							<li>
								<Link
									to="/soldes"
									className="text-white hover:text-gray-300"
								>
									Soldes
								</Link>
							</li>
							<li>
								<Link
									to="/interets"
									className="text-white hover:text-gray-300"
								>
									Taux d'intérêts
								</Link>
							</li>
							<li>
								<Link
									to="/retrait"
									className="text-white hover:text-gray-300"
								>
									Retrait
								</Link>
							</li>
							<li>
								<Link
									to="/virements"
									className="text-white hover:text-gray-300"
								>
									Virements
								</Link>
							</li>
							<li>
								<Link
									to="/releve"
									className="text-white hover:text-gray-300"
								>
									Relevé de comptes
								</Link>
							</li>
							<li>
								<Link
									to="/categorie"
									className="text-white hover:text-gray-300"
								>
									Catégorie
								</Link>
							</li>
						</ul>
					</div>
					<div className="md:hidden">
						{/* Responsive menu button */}
						<button className="text-white hover:text-gray-300 focus:outline-none">
							<svg
								className="h-6 w-6 fill-current"
								viewBox="0 0 24 24"
							>
								<path
									d="M4 6h16M4 12h16m-7 6h7"
									strokeLinecap="round"
									strokeLinejoin="round"
									strokeWidth="2"
								/>
							</svg>
						</button>
					</div>
				</div>
			</div>
		</nav>
	);
};
export default NavBar;
