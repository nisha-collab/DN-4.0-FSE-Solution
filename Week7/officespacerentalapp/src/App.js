import React from "react";
import "./App.css";

function App() {
  const officeSpaces = [
    {
      image: "https://ik.imagekit.io/qdesq/qdesq/919d249ab7a1aace4c4c44d08d4fc95a_vflWEWW4r.jpg",
      name: "WorkHive",
      rent: 55000,
      address: "MG Road, Bengaluru"
     
    },
    {image: "https://qdesq.imagekit.io/img/tr:n-listing_image_hq/image/upload/v1606887251/ejpydzaanst6m7hejcpq.webp",
      name: "InnoSpace",
      rent: 75000,
      address: "Cyber City, Gurugram"},
      
    {
      image: "https://i0.wp.com/workie.in/wp-content/uploads/2023/10/spaces-for-rent.jpeg?fit=1024%2C768&ssl=1",
      name: "Startup Hub",
      rent: 62000,
      address: "Hitech City, Hyderabad"
      
    },
    {
      image: "https://qdesq.imagekit.io/img/tr:n-listing_image_hq/image/upload/v1722412967/bad4iwt6jejsju6p9pm6.webp",
      name: "Budget Space",
      rent: 45000,
      address: "Viman Nagar, Pune"
      
    }
  ];

  return (
    <div className="App">
      <h1>Office Space, at Affordable Range</h1>
      <div className="container">
        {officeSpaces.map((office, index) => (
          <div className="card" key={index}>
            <img src={office.image} alt={office.name} />
            <h2>{office.name}</h2>
            <p>Address: {office.address}</p>
            <p
              className="rent"
              style={{ color: office.rent < 60000 ? "red" : "green" }}
            >
              Rent: ₹{office.rent}
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;
