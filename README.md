# Simple Tic-Tac-Toe Game (Java)

[![Hyperskill](https://hyperskill.org/static/img/logo-small.svg)](https://hyperskill.org/)

This is a simple console-based Tic-Tac-Toe game implemented in Java as part of my learning journey on the [Hyperskill](https://hyperskill.org/) platform. The project was rated as **Medium** difficulty.

## Project Description

This project implements a classic Tic-Tac-Toe game where two players take turns marking spaces on a 3x3 grid. After each move, the program checks if either player has won or if the game has ended in a draw.

The project was developed in several stages on Hyperskill, each with specific requirements and challenges to overcome.

## Key Features

* **3x3 Game Board:** A standard 3x3 grid for playing Tic-Tac-Toe.
* **Alternating Turns:** Players take turns entering their moves.
* **Input Validation:** The program validates user input to ensure it corresponds to a valid cell on the board.
* **Win Condition Check:** After each move, the program checks all rows, columns, and diagonals to determine if a player has achieved three in a row.
* **Draw Detection:** The game detects when all cells are filled without a winner, resulting in a draw.

## Skills Practiced

This project allowed me to practice and reinforce the following Java concepts:

* **2D Arrays:** Efficiently managing and manipulating the game board.
* **User Input Handling:** Reading and processing input from the console.
* **Input Validation:** Ensuring the user provides valid input.
* **Algorithm Design:** Developing a robust algorithm to check for winning conditions.

## Winning Condition Algorithm (Implementation Detail)

One of the most interesting parts of this project was devising an algorithm to check for a winner. My final approach involved the following:

1.  **Two 2D Arrays:**
    * One array stores the actual moves of the players ('X' and 'O').
    * A second, parallel 2D array represents the same board, but with 'X' replaced by the integer `1` and 'O' replaced by the integer `10`.

2.  **Summation Methods:** I implemented methods to calculate the sum of:
    * Each row in the numerical array.
    * Each column in the numerical array.
    * Both main diagonals in the numerical array.

3.  **Winner Determination:** If any of these sums equals `3` (representing three 'X's) or `30` (representing three 'O's), then the corresponding player is declared the winner.

This approach provided a clean and efficient way to check all possible winning lines.

## How to Run

1.  Ensure you have Java Development Kit (JDK) installed on your system.
2.  Clone this repository to your local machine.
3.  Navigate to the project directory in your terminal.
4.  Compile the Java source file (e.g., `javac Main.java`, assuming your main class is named `Main`).
5.  Run the compiled class (e.g., `java Main`).

The game will then start in the console, prompting players to enter their moves.



## Acknowledgements

This project was completed as part of the Java learning track on [Hyperskill](https://hyperskill.org/).

---
