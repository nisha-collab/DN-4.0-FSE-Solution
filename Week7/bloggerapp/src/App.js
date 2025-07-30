import React, { Component } from 'react';
import './App.css';
import { books, blogs, courses } from './data';

class App extends Component {
  render() {
    const bookdet = (
      <ul>
        {books.map(book => (
          <div key={book.id}>
            <h3>{book.bname}</h3>
            <h4>{book.price}</h4>
          </div>
        ))}
      </ul>
    );

    const blogdet = (
        <div>
            {blogs.map(blog => (
                <div key={blog.id}>
                    <h3>{blog.title}</h3>
                    <h4>{blog.author}</h4>
                    <p>{blog.content}</p>
                </div>
            ))}
        </div>
    );

    const coursedet = (
        <div>
            {courses.map(course => (
                <div key={course.id}>
                    <h3>{course.name}</h3>
                    <h4>{course.date}</h4>
                </div>
            ))}
        </div>
    );

    return (
      <div>
        <div className="details-container">
          <div className="mystyle1">
            <h1>Course Details</h1>
            {coursedet}
          </div>
          <div className="st2">
            <h1>Book Details</h1>
            {bookdet}
          </div>
          <div className="v1">
            <h1>Blog Details</h1>
            {blogdet}
          </div>
        </div>
      </div>
    );
  }
}

export default App;