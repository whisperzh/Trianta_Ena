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
4. `TE_Player.java` -> Child of the `Player` class. The class contains all the attributes and methods that correspond to a player or the banker in a TE game. This class has a private `Hand` class which is used to track the hand cards of the player and the banker. 

### Utilities package
1. `Cache.java` -> This is a general purpose utility class to store player and game-state information.

## Notes
---------------------------------------------------------------------------
1. Notes to grader -> NIL

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory `src` after unzipping the files
2. Run the following instructions:
>`javac -d bin com\Trianta_Ena\Main.java` \
>`java -cp bin com.Trianta_Ena.Main`

## Input/Output Example
---------------------------------------------------------------------------
```
=======================================================

>>>=== Hi there! Welcome to the boardgames arena ===<<<

=======================================================


>>>=== Please choose the game to start playing ===<<<

Games
	[1] Tic-tac-toe (not available at the moment)
	[2] Order and Chaos (not available at the moment)
	[3] Trianta Ena

3
Your Input: [3]


Starting Trianta Ena! Please note the following.


	1. At the start of the game, Player 1 will always be the dealer. When the round ends, dealer can be changed.

Please enter the count of the players: 

=== Please enter a number between 2 and 9 

2
Your input is 2


=== Please enter your name
p1
Your input p1

>>>=== You are the dealer! ===<<<

=== Please enter your name
p2
Your input p2


FIVE has been added to p1's hand card

p1's hand card value is 5

p1's hand cards are:
FIVE
--------


THREE has been added to p2's hand card

p2's hand card value is 3

p2's hand cards are:
THREE
--------

p2, would you like to [b]et or [f]old? 
Enter your choice 'b' or 'f':
b
=== Please enter the bet amount: 
50
p2's remaining cash: 50


SIX has been added to p2's hand card

p2's hand card value is 9

p2's hand cards are:
THREE
SIX
--------


SIX has been added to p2's hand card

p2's hand card value is 15

p2's hand cards are:
THREE
SIX
SIX
--------

p2, would you like to [h]it or [s]tand? 
Enter your choice 'h' or 's':
h

TWO has been added to p2's hand card

p2's hand card value is 17

p2's hand cards are:
THREE
SIX
SIX
TWO
--------

p2, would you like to [h]it or [s]tand? 
Enter your choice 'h' or 's':
h

EIGHT has been added to p2's hand card

p2's hand card value is 25

p2's hand cards are:
THREE
SIX
SIX
TWO
EIGHT
--------

p2, would you like to [h]it or [s]tand? 
Enter your choice 'h' or 's':
h

ACE has been added to p2's hand card

p2's hand card value is 36

p2's hand cards are:
THREE
SIX
SIX
TWO
EIGHT
ACE
--------

p2's got 1 ACE card
One of the card's value can either be 11 or 1
>>> Please enter the value of this card(11/1)
1
p2, would you like to [h]it or [s]tand? 
Enter your choice 'h' or 's':
h

FOUR has been added to p2's hand card

p2's hand card value is 30

p2's hand cards are:
THREE
SIX
SIX
TWO
EIGHT
FOUR
ACE
--------

p2's got 1 ACE card
One of the card's value can either be 11 or 1
>>> Please enter the value of this card(11/1)
1
p2, would you like to [h]it or [s]tand? 
Enter your choice 'h' or 's':
s

TEN has been added to p1's hand card

p1's hand card value is 15

p1's hand cards are:
FIVE
TEN
--------


THREE has been added to p1's hand card

p1's hand card value is 18

p1's hand cards are:
FIVE
TEN
THREE
--------


TEN has been added to p1's hand card

p1's hand card value is 28

p1's hand cards are:
FIVE
TEN
THREE
TEN
--------

p1, would you like to [h]it or [s]tand? 
Enter your choice 'h' or 's':
s
=== p2 win this round ===

p2's remaining cash: 150

p2, do you accept to be a dealer?(y/n)

y
Your Input: Yes

QUEEN has been added to p1's hand card

p1's hand card value is 10

p1's hand cards are:
QUEEN
--------

p1, would you like to [b]et or [f]old? 
Enter your choice 'b' or 'f':
b
=== Please enter the bet amount: 
50
p1's remaining cash: 200


JACK has been added to p1's hand card

p1's hand card value is 20

p1's hand cards are:
QUEEN
JACK
--------


EIGHT has been added to p1's hand card

p1's hand card value is 28

p1's hand cards are:
QUEEN
JACK
EIGHT
--------


JACK has been added to p2's hand card

p2's hand card value is 10

p2's hand cards are:
JACK
--------

p1, would you like to [h]it or [s]tand? 
Enter your choice 'h' or 's':
h

EIGHT has been added to p1's hand card

p1's hand card value is 36

p1's hand cards are:
QUEEN
JACK
EIGHT
EIGHT
--------

*********************************

p1 have gone bust!

*********************************

EIGHT has been added to p2's hand card

p2's hand card value is 18

p2's hand cards are:
JACK
EIGHT
--------


QUEEN has been added to p2's hand card

p2's hand card value is 28

p2's hand cards are:
JACK
EIGHT
QUEEN
--------

p2, would you like to [h]it or [s]tand? 
Enter your choice 'h' or 's':
h

FIVE has been added to p2's hand card

p2's hand card value is 33

p2's hand cards are:
JACK
EIGHT
QUEEN
FIVE
--------

*********************************

p2 have gone bust!

*********************************
p2's remaining cash: 200

p1, do you accept to be a dealer?(y/n)

y
Your Input: Yes

KING has been added to p1's hand card

p1's hand card value is 10

p1's hand cards are:
KING
--------


SEVEN has been added to p2's hand card

p2's hand card value is 7

p2's hand cards are:
SEVEN
--------

p2, would you like to [b]et or [f]old? 
Enter your choice 'b' or 'f':

```
