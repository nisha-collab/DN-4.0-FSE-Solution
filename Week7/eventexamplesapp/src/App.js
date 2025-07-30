import React, { Component } from 'react';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      counter: 1,
      amount: '80',
      currency: 'Euro'
    };
    this.incrementCounter = this.incrementCounter.bind(this);
    this.decrementCounter = this.decrementCounter.bind(this);
    this.sayHello = this.sayHello.bind(this);
    this.handleIncreaseButtonClick = this.handleIncreaseButtonClick.bind(this);
    this.sayWelcome = this.sayWelcome.bind(this); // Bind sayWelcome
    this.handleSyntheticClick = this.handleSyntheticClick.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  incrementCounter() {
    this.setState(prevState => ({
      counter: prevState.counter + 1,
    }));
  }

  decrementCounter() {
    this.setState(prevState => ({
      counter: prevState.counter - 1,
    }));
  }

  sayHello() {
    alert(`Hello! Current Counter: ${this.state.counter}`);
  }

  handleIncreaseButtonClick() {
    this.incrementCounter();
    this.sayHello();
  }

  sayWelcome(message) {
    alert("Welcome");
  }

  handleSyntheticClick(event) {
    alert("I was clicked");
  }

  handleChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  handleSubmit(event) {
    event.preventDefault();

    const { amount, currency } = this.state;

    let convertedAmount = '';
    if (currency.toLowerCase() === 'euro' && !isNaN(parseFloat(amount))) {
      convertedAmount = (parseFloat(amount) * 80);
    } else {
      convertedAmount = amount;
    }

    alert(`Converting to Euro Amount is ${convertedAmount}`);
  }

  render() {
    return (
      <div style={{ padding: '20px', textAlign: 'left' }}>
        <div>
          {this.state.counter}
        </div>

        <div>
          <button onClick={this.handleIncreaseButtonClick} style={{ display: 'block', marginBottom: '5px' }}>Increment</button>
          <button onClick={this.decrementCounter} style={{ display: 'block', marginBottom: '5px' }}>Decrement</button>
          <button onClick={() => this.sayWelcome('welcome')} style={{ display: 'block', marginBottom: '5px' }}>Say welcome</button>
          <button onClick={this.handleSyntheticClick} style={{ display: 'block', marginBottom: '5px' }}>Click on me</button>
        </div>

        <h2 style={{ color: 'green' }}>Currency Convertor!!!</h2>

        <form onSubmit={this.handleSubmit}>
          <div style={{ marginBottom: '10px' }}>
            <label>Amount: </label>
            <input
              type="text"
              name="amount"
              value={this.state.amount}
              onChange={this.handleChange}
            />
          </div>
          <div style={{ marginBottom: '10px' }}>
            <label>Currency: </label>
            <input
              type="text"
              name="currency"
              value={this.state.currency}
              onChange={this.handleChange}
            />
          </div>
          <div>
            <button type="submit">Submit</button>
          </div>
        </form>
      </div>
    );
  }
}

export default App;