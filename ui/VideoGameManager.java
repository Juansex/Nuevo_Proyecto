package ui;

import java.util.Scanner;
import model.VideoGameController;


public class VideoGameManager{
public static Scanner sc=new Scanner(System.in);
public static VideoGameController videoGame;
    
/**
    *Main 
    */
    public static void main(String args[]) {
        createVideoGame();
        menu();
    }

/**
    *Creates the Video game 
    *@param name Is the name of the video game.
    *@param resolutionX is the number of pixels in the x axis of the screen.
    *@param resolutionY is the number of pixels in the Y axis of the screen.
    *@param videoGame is the object VideoGame that is created.
    */
    public static void createVideoGame(){
        String name= "Videogame 1";
        int resolutionX=640;
        int resolutionY=480;
        videoGame= new VideoGameController(name, resolutionX, resolutionY);
    }

/** 
     * Menu 
    * @param choice is the number of the option from the menu.
    */
    public static void menu(){
        System.out.println("Enter a number of the menu");
        System.out.println("1. Create player");
        System.out.println("2. Register enemie to a level");
        System.out.println("3. Register treasure to a 3level");
        System.out.println("4. Modify player points");
        System.out.println("5. Level up player");
        
        System.out.println("6. Inform enemies and treasures");
        System.out.println("7. Inform the quantity of treasures and enemies found in each level");
        System.out.println("8. Report the quantity encountered of an enemy at all levels");
        System.out.println("9. Reporting the most repeated treasure at all levels");
        System.out.println("10. Report the highest scoring enemy and the level at which it is located");
        System.out.println("11. Report the number of consonants found in the names of enemies in the game");
        System.out.println("12. Report top 5 players according to score");
        System.out.println("13. Complete");

        String choice= sc.nextLine();
        switch (choice) {
            case "1":
                registerPlayer();
                menu();
                break;
            case "2":
                registerEnemy();
                menu();
                break;
            case "3":
                registerTreasure();
                menu();
                break;
            case "4":
                modifyPoints();
                menu();
                break;
            case "5":
                levelUp();
                menu();
                break;
            case "6":
                informTreasuresAndEnemies();
                menu();
                break;
            case "7":
                numberOfTreasures();
                menu();
                break;
            case "8":
                numberOfEnemies();
                menu();
                break;
            case "9":
                mostRepeatedTreasure();
                menu();
                break;
            case "10":
                biggestEnemy();
                menu();
                break;
            case "11":
                numberOfConsonants();
                menu();
                break;
            case "12":
                top5();
                menu();
                break;
            case "13":
                System.out.println("Thanks");
                break;
            default: 
                System.out.println("Enter a valid option");
                menu();
        }
    }

/**
    *Registers a new player 
    *@param nickname Is the unique id of the new player.
    *@param name is the name of the player
    *@param points The number of points that this player has.
    *@param lives The number of lives that a player has.
    *@param lvl The level of a player.
    *@param message a confirmation or error message displayed after trying to add a new player.
    */
    public static void registerPlayer(){
        System.out.println("1. Create a player");
        System.out.println("Enter the player nickname");
        String nickname= sc.nextLine();
        System.out.println("Enter your name");
        String name= sc.nextLine();
        int points=10;
        int lives=5;
        int lvl=1;
        String message= videoGame.addPlayer(nickname,name,points,lives,lvl);
        System.out.println(message);
    }
    
/**
    *Registers the characteristics of a level 
    *@param level Is the number of the level to modify.
    *@param scoreToNextLevel is the number of points a player must obtain to get to the next level.
    */
    public static void registerLevel(){
        System.out.println("Enter the number of the level you wish to register");
        int level= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the score that this level requires to move to the next level");
        int scoreToNextLevel= sc.nextInt();
        sc.nextLine();
    }

/**
    *Registers a new treasure to a certain level 
    *@param name Is the name of the treasure.
    *@param imageURL Is the URL of the image of the treasure.
    *@param pointsIfFound the number of points that a player gets after finding the treasure.
    *@param level the level in which the treasure is going to be added.
    *@param msg is the message displayed after adding the treasure.
    */
    public static void registerTreasure(){
        System.out.println("3. Register treasure at one level");
        System.out.println("Enter the name of the treasure");
        String name= sc.nextLine();
        System.out.println("Enter the URL of the image");
        String imageURL= sc.nextLine();
        System.out.println("Enter the points awarded for this treasure when it is found");
        int pointsIfFound= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the level at which you want to register this treasure");
        int level= sc.nextInt();
        sc.nextLine();
        if (level>10 || level<1){
            System.out.println("Enter a valid number (1 to 10) ");
            level= sc.nextInt();
            sc.nextLine();
        }
        String msg= videoGame.addTreasure(name, imageURL, pointsIfFound,level);
        System.out.println(msg);
    }

/**
    *Registers a new enemy to a certain level 
    *@param id Is the identifier of the enemy.
    *@param pointsGiven Is the number of points a player recieves after defeating the enemy.
    *@param pointsSubtracted the number of points that a player gets subtracted if the enemy defeats them.
    *@param level the level in which the enemy is going to be added.
    *@param msg is the message displayed after adding the Enemy.
    */
    public static void registerEnemy(){
        System.out.println("2. Register enemy at one level");
        System.out.println("Enter the name of the enemy");
        String id= sc.nextLine();
        System.out.println("Enter the points awarded by this enemy when it is defeated.");
        int pointsGiven= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the type of enemie:\n 1. OGRO \n2. ABSTRACTO \n3. JEFE \n4. MAGO");
        int enemyType= sc.nextInt();
        if (enemyType>4 || enemyType<1){
            System.out.println("Enter a valid number (1 to 4) ");
            enemyType= sc.nextInt();
            sc.nextLine();
        }
        sc.nextLine();
        System.out.println("Enter the points removed by this enemy when it defeats you.");
        int pointsSubtracted= sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the number of the level in which you want to register this enemy");
        int level= sc.nextInt();
        sc.nextLine();
        if (level>10 || level<1){
            System.out.println("Enter a valid number (1 to 10) ");
            level= sc.nextInt();
            sc.nextLine();
        }
        String msg= videoGame.addEnemy(id, pointsGiven, pointsSubtracted,level, enemyType);
        System.out.println(msg);
    }

/**
    *Modifies the points of a certain player 
    *@param nickname Is the identifier of the player.
    *@param points Is the number of points the player will recieve.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void modifyPoints(){
        System.out.println("4. Modify a player's score");
        System.out.println("Enter the player's nickname");
        String nickname= sc.nextLine();
        System.out.println("Enter the new score");
        int points= sc.nextInt();
        sc.nextLine();
        String msg= videoGame.changePoints(nickname,points);
        System.out.println(msg);
    }

/**
    *Increases the level of a player 
    *@param nickname Is the identifier of the player.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void levelUp(){
        System.out.println("5. Level up a player");
        System.out.println("Enter the player's name");
        String nickname= sc.nextLine();
        String msg= videoGame.levelUp(nickname);
        System.out.println(msg);
    }

/**
    *Informs the treasures and enemies of a level 
    *@param lvl Is the number of the level.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void informTreasuresAndEnemies(){
        System.out.println("6. Report treasures and enemies");
        System.out.println("Enter the level number to know your treasures and enemies.");
        int lvl=sc.nextInt();
        sc.nextLine();
        String msg= videoGame.informTreasuresAndEnemies(lvl);
        System.out.println(msg);
    }

/**
    *Informs the total number of treasures in the game 
    *@param treasurename Is the name of the treasure.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void numberOfTreasures(){
        System.out.println("7. Report the amount found of a treasure at all levels");
        System.out.println("Enter the name of the treasure");
        String treasurename= sc.nextLine();
        String msg= videoGame.numberOfTreasures(treasurename);
        System.out.println(msg);
    }

/**
    *Informs the total number of an enemy in the game 
    *@param enemyName Is the name of the enemy.
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void numberOfEnemies(){
        System.out.println("8. Report the quantity encountered of an enemy at all levels");
        System.out.println("Enter the name of the enemy");
        String enemyName= sc.nextLine();
        String msg= videoGame.numberOfEnemies(enemyName);
        System.out.println(msg);
    }

/**
    *Informs the most repeated treasure in the game 
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void mostRepeatedTreasure(){
        System.out.println("9. Report the most repeated treasure at all levels.");
        String msg= videoGame.mostRepeatedTreasure();
        System.out.println("The most repeated treasure in all levels is: "+msg);
    }

/**
    *Informs the enemy that gives the most points in the game 
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void biggestEnemy(){
        System.out.println("10. Report the highest scoring enemy and the level at which it is located.");
        String msg= videoGame.biggestEnemy();
        System.out.println(msg);
    }

/**
    *Informs the number of consonants in all the names of the enemies in the game 
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void numberOfConsonants(){
        System.out.println("11. Report the number of consonants found in the names of enemies in the game.");
        String msg= videoGame.consonants();
        System.out.println(msg);
    }

/**
    *Informs the top 5 playes based on the points 
    *@param msg Is the message that will be displayed after the process is completed.
    */
    public static void top5(){
        System.out.println("12. Report top 5 players according to score");
        System.out.println(videoGame.top5());
    }
}