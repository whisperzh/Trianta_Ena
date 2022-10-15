# CS611-Assignment #2
## Trianta Ena
---------------------------------------------------------------------------


## Files
---------------------------------------------------------------------------
1. `Main.java` -> The class is the entry point to the game and contains the main() method.
2. `GameSelect.java` -> The class is responsible for displaying the menu of available games and present rules for the selected game.

### Drivers package
1. `Driver.java` -> The class contains the infrastructure to build a driver for any game. The class is the parent class for the following `TE_Driver` class.
2. `TE_Driver.java` ->  Inherits the `Driver` class. Additional TE specific attributes and methods have been implemented in this class.

### Boards package
1. `Board.java` -> The class contains the infrastructure to build a board for any game. The class is the parent class for the following `TE_Board` class.
2. `TE_Board.java` -> Inherits the `Board` class. Additional TE specific attributes and methods have been implemented in this class.

### Interfaces package
#### Behaviors sub package
1. `Behavior.java` -> The interface which provides the infrastructure for extending player/game behavior.
2. `Player_Behavior.java` -> Child of Behavior interface. This interface provides methods that can be overridden by a player from any particular game.
3. `TE_Player_Behavior.java` -> Extends `Player_Behavior` interface. The interface provides methods that are common between a player and the banker (in our TE game there are 2 types of players, "Player" and "Banker").
4. `Team_Behavior.java` -> Child of Behavior interface. Enables extendability for games with teams of players.

### Items package
1. `Item.java` -> The parent class for pieces, cards, markers used by players in any game type.
2. `Card.java` -> Child of the `Item` class. The class entails the attributes and methods corresponding to a card in a standard 52-card deck. The class can be inherited to add functionality based on the game in which the cards are used.
3. `TE_Card.java` -> Child of the `Card` class.  The class contains TE specific card information.

### Units package
1. `Units.java` -> The class represents a player, one of the building blocks in any game. A unit will be a team in a team-based game, it will be a player in an individual player-based game.
2. `Teams.java` -> Child of the `Units` class. Represents a team of players in any game.
3. `Player.java` -> Child of the `Units` class. Represents an individual player in any game.
4. `TE_Player.java` -> Child of the `Player` class. The class contains all the attributes and methods that correspond to a player or the banker in a TE game.

### Utilities package
1. `Cache.java` -> This is a general purpose utility class to store player and game-state information.

## Notes
---------------------------------------------------------------------------
1. Notes to grader -> NIL

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory `tic-tac-toe` after unzipping the files
2. Run the following instructions:
>`javac -d bin src/**/*.java` \
>`java -cp bin Default.Driver`

## Input/Output Example
---------------------------------------------------------------------------
```
```