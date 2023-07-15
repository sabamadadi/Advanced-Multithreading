# Advanced Multithreading

Seventh Assignment of Advanced Programming course at Shahid Beheshti University (Spring 2023)

Score: 100 out of 100

## Introduction
In this assignment, you are given three problems focused on various areas of multithreaded programming. Solve each exercise according to the provided guidelines.


## Objectives
- Review the concepts of multithreaded programming and utilize them correctly
- Research pi calculation algorithms
- Familiarize yourself with the Semaphore, CountDownLatch, and BigDecimal classes
- Write a report on the assignment


## Tasks
1. Fork this repository and clone the fork to your local machine. Ensure to create a new Git branch before starting your work
2. Complete the following exercises based on the instructions provided:

   - `Calculate Pi`: Calculate the value of pi up to 1000 digits after the floating point. Find more instructions in the `PiCalculator` class.
   - `Priority Simulator`: Manage three different thread types and ensure the order of execution between them is correctly handled. Try to use a `CountDownLatch` for this exercise. Find more instructions in the `Runner` class.
   - `Semaphore`: Solve a synchronization problem using a Semaphore that allows 2 threads to enter the critical section.  Find more instructions in the `Controller` class.
3. Commit your changes and push your commits to your fork on Github. Create a pull request (assigned to your mentor) to merge your changes to the main branch of your fork on Github.


## Notes
- You can find unit tests for the first two exercises (`Calculate Pi` and `Priority Simulator`). Use these to ensure you've implemented the code correctly.
- You are NOT allowed to use the `Thread.Sleep()` method for the `Priority Simulator` exercise.
- You are NOT allowed to use any other form of synchronization tool for the `Semaphore` exercise. Only Semaphores may be used.
- Your report should include details on the solution you chose for each exercise (and why you chose it). Try to focus on the `Calculate Pi` exercise and explain the mathematical algorithm(s) you tried in detail.


## Evaluation
- Your code should compile and run without any errors
- Your code should be well-organized, readable, properly commented and should follow clean code principles
- Your code should pass all of the provided unit tests
- You should use Git for version control and include meaningful commit messages


## Submission
- Push your code to your fork on Github
- Upload your report to your fork on GitHub


The deadline for submitting your code is Wednesday, May 10 (20th of Ordibehesht). Good luck, happy coding and à bientôt!
