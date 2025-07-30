import styles from "./CohortDetails.module.css";

function CohortDetails({ cohort }) {
  return (
    <div className={styles.card}>
      <h3 className={styles.title}>
        {cohort.cohortCode} - <span className={styles.tech}>{cohort.technology}</span>
      </h3>
      <dl className={styles.details}>
        <dt>Started On</dt>
        <dd>{cohort.startDate}</dd>
        <dt>Current Status</dt>
        <dd>{cohort.currentStatus}</dd>
        <dt>Coach</dt>
        <dd>{cohort.coachName}</dd>
        <dt>Trainer</dt>
        <dd>{cohort.trainerName}</dd>
      </dl>
    </div>
  );
}

export default CohortDetails;
