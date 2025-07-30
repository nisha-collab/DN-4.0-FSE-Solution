import React from "react";

function IndianPlayers() {
  const indianPlayers = ["Sachin1", "Dhoni2", "Virat3", "Rohit4", "Yuvraj5", "Raina6"];

  // Destructuring odd and even players
  const [first, second, third, fourth, fifth, sixth] = indianPlayers;

  // Merge two arrays
  const T20players = ["Mr. First Player", "Mr. Second Player", "Mr. Third Player"];
  const RanjiPlayers = ["Mr. Fourth Player", "Mr. Fifth Player", "Mr. Sixth Player"];
  const merged = [...T20players, ...RanjiPlayers];

  return (
    <div>
      <h2><b>Odd Players</b></h2>
      <ul>
        <li>First : {first}</li>
        <li>Third : {third}</li>
        <li>Fifth : {fifth}</li>
      </ul>
       <hr />

      <h2><b>Even Players</b></h2>
      <ul>
        <li>Second : {second}</li>
        <li>Fourth : {fourth}</li>
        <li>Sixth : {sixth}</li>
      </ul>
       <hr />

      <h2><b>List of Indian Players Merged:</b></h2>
      <ul>
        {merged.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>
    </div>
  );
}

export default IndianPlayers;
