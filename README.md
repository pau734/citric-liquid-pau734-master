# citric-liquid-pau734-master
Clone of the game 100% Orange Juice, made using the base code given.

Some of the biggest changes are:
1. There is no "Type class" anymmore, instead, each type of panel is created by it own class (HomePanel, NeutralPanel, DropPanel, etc.) that extends 
   and abstract class (AbstractPanel) which implements the Panel Interface (IPanel). Therefore, all the methods that were related to the "type" atribute
   in the base code were deleted, however the rest were quite useful so they stayed almost the same but instead of being directly in the Panel class, now they 
   are in the AbstractPanel class so they can be used by all panels. 
2. The method "activatedBy" is now implemented in each different panel, so now it doesn't use a switch statement. The panels that are related to battles, cards
   or turns have this method empty for now.
3. As for the Player, since the Boss Unit, the Wild Unit and the Players share quite a bit of functionalities, I took the original Player class code and created 
   an "AbstracCharacter" class, and an Interface (ICharacter) which have all the methods that all 3 Characters should have. And then I created the Player, Boss
   Unit and Wild Unit classes which contain methods that are exclusive of each of them. Also in the case of the player, other atributes are added such as "wins",
   "homePanel", "normaObjective", "normaLevel", all of them having deafault values 0, null, "Stars", 1 respectively.
4. The roll method is, for now, in the AbstractCharacter class since all the characters need to be able to roll the dice in order to attack, defend and evade.
   It will probably be moved to the controller for the next homework submission.
5. Even though battles only happen when the Players fall into certain Panels,it was considered that the battle itself must be called by the Panel, but that the attack,
   evade and defense methods should be in the AbstractCharacter class. It is this way (for now) because the notion of a Panel having the capability of reducing
   a character's hit points doesn't sit right with me, as I think that the Characters themselves should be the ones to reduce their own hit points.
6. I did something similar for the HomePanel, it should be the HomePanel the one that invokes the normaCheck method, however I think the player is the one who
   should increase their own level, that's why normaCheck is defined in the Player class but called in the HomePanel class.
7. The "id" atribute for the panels was added only as a way to differentiate panels, even though panels can't posibly have the same players on them at the same
   time, the notion of "time" still isn't quite clear since I still haven't used a controller. For example, I have all the elements to meke a board, but the 
   actual board that should be created before the game even begins doesn't exist yet, because of this I don't have a list with all the panels that were 
   created, so I can't differentiate two panels by comparing them to the already created ones using only nextPanels and PlayersOnPanel. This is why I think that
   the id is necessary (only for now though), it was made a string atribute at first, however it is a bit tedious to deal with strings so i changed it to
   an integer atribute out of convenience.
8. For a similar reason the setHomePanel method in the Player class is not implemented, in order to set a homePanel for a Player I need to know what the whole
   board looks like and which home panels I can choose from (I can't create a new home panel to give it to a player since there are maximum of 4 in the whole game).
9. Some getters and setters were added to both the board's classes and the character's classes.
10. The test for the panels stayed almost the same, except that there is now a method to test the new getId method. 
11. The player test from the original code became the AbstractCharacterTest with the addtion of the getAttack, getDefense and getEvade methods which are just 
   basic tests for the getters of these atributes. Also since they depend of a method that uses Random (roll) attackConsistencyTest, defenseConsistencyTest 
   and evadeConsistencyTest were created in order to check that the attack(), defense() and evade() characters work well in different circumstances and with 
   different types of characters.
12. Since Player has many exclusive methods, a particular test called "PlayerTest" was created for this type of character. The winsTest, test the getWins, 
    increaseWins and reduceWins methods. Then there is the playerHomePanelTest which is used to test the getHomePanel method, that gets the home panel associated
    to a certain Player. The normaObjectiveTest is for the getNormaObjective and setNormaObjective methods. Finally there is the normaLevelTest for the getNormaLevel,
    setNormaLevel, normaCheck and normaClear methods and a normaLevelConsistencyTest which I did because the normaLevel can be modified but as it always need to follow
    several rules in order to do so, I thought it would be useful to make a more throughtout test.
   
   


