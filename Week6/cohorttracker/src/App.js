import "./App.css";
import { CohortsData } from "./Cohort";
import CohortDetails from "./components/CohortDetails";

function App() {
  return (
    <div className="container">
      <h1 className="heading">Cohorts Details</h1>
      <div className="cards">
        {CohortsData.map((cohort, index) => (
          <CohortDetails key={index} cohort={cohort} />
        ))}
      </div>
    </div>
  );
}

export default App;
