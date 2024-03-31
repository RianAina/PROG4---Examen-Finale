import React from 'react';

const Home = () => {
  return (
    <div className="bg-black min-h-screen">
      <nav className="py-4 px-8 flex justify-between items-center">
        <div className="text-white font-bold text-lg">Botiko</div>
        <div className="text-gray-400 space-x-4">
          <a href="#" className="hover:text-white">About us</a>
          <a href="#" className="hover:text-white">Projects</a>
          <a href="#" className="hover:text-white">Services</a>
          <a href="#" className="hover:text-white">Shop</a>
          <a href="#" className="hover:text-white">Contact</a>
        </div>
      </nav>
      <div className="flex px-8 py-16">
        <div className="w-1/2 pr-8">
          <div className="bg-black p-8 rounded-lg shadow-lg">
            <div className="text-white uppercase font-bold mb-4">Interior</div>
            <h1 className="text-white text-5xl font-bold mb-8">Design</h1>
            <p className="text-gray-400 mb-8">
              The stylish interior make us want to spend more time in it. We present interesting sets to create an apartment. We choose the right colors according to our own taste.
            </p>
            <a href="#" className="text-white bg-green-500 hover:bg-green-600 py-2 px-4 rounded-lg">
              Read more
            </a>
          </div>
        </div>
        <div className="w-1/2 pl-8">
          <div className="bg-gray-800 p-8 rounded-lg shadow-lg">
            <h2 className="text-white text-2xl font-bold mb-4">A beautiful Sofa</h2>
            <p className="text-gray-400 mb-4">The sofa is made of solid materials.</p>
            <p className="text-gray-400 mb-4">Comfortable to use with matched pillows.</p>
            <p className="text-gray-400 mb-8">Perfect for the living room.</p>
            <div className="flex items-center">
              <div className="bg-orange-500 text-white rounded-full w-8 h-8 flex items-center justify-center mr-4">+</div>
              <div className="bg-orange-500 text-white rounded-full w-8 h-8 flex items-center justify-center mr-4">+</div>
              <div className="bg-white rounded-lg p-4">
                <h3 className="text-black font-bold">Next post</h3>
                <p className="text-gray-600">Flowers in beautiful glass composition.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;