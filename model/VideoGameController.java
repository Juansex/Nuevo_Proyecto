package model;
public class VideoGameController{
    //attributes
	private String name;
	private int resolutionX;
    private int resolutionY;

	//relations
	private Player[] players;
    private Level[] levels;

	//methods

/** 
    * Controler class VideoGame
    * @param name is the name of the video game.
    * @param resolutionX is the number of pixels in the x axis of the screen.
    * @param resolutionY is the number of pixels in the Y axis of the screen.
    * @param levels is the array containing the 10 levels of the game.
    * @param players is the array containing the 25 players of the game.
    */
    public VideoGameController(String name, int resolutionX, int resolutionY){
        this.name= name;
        this.resolutionX= resolutionX;
        this.resolutionY= resolutionY;
        levels= new Level[10];
        addLevel();
        players= new Player[25];
    }

/** 
    *Adds a new player to the game 
    *@param nickname Is the unique id of the new player.
    *@param name is the name of the player
    *@param points The number of points that this player has.
    *@param lives The number of lives that a player has.
    *@param lvl The level of a player.
    *@param message a confirmation or error message displayed after trying to add a new player.
    *@param objPlayer an object containing the information of a player.
    *@param available shows if the nickname is allready taken.
    *@return the confirmation message when completed 
    */
    public String addPlayer(String nickname,String name,int points,int lives,int lvl){
        String message="Error";
        if (searchPlayer(nickname)){
            Player objPlayer= new Player(nickname, name, points,lives,lvl);

            for (int i = 0; i < players.length; i++) {
                
                if(players[i]==null){
                    players[i]=objPlayer;
                    i=players.length;
                    message="Player successfully created";
                }
                else{
                    message="No spaces available to create players";
                }
            }	  
		}
        else {
            message="This nickname has been created";  
        } 
        return message; 
    }

/** 
    *Looks for a player nickname inside the player array 
    *@param nickname Is the unique id of the new player.
    *@param isAvailable shows if the nickname is available or not.
    *@return isAvailable
    */
    public boolean searchPlayer(String nickname){
        boolean isAvailable=true;
        for (int i = 0; i < players.length; i++) {
            if(isAvailable && players[i]!=null && players[i].getNickname().equalsIgnoreCase(nickname)){
                isAvailable=false;
            }
        }
        return isAvailable;
    }

/** 
    *Creates all the levels and saves them inside the array level 
    *@param id Is the unique id of the level.
    *@param scoreToNextLevel is the number of points to advance to the next level.
    */
    public void addLevel(){
        int scoreToNextLevel=10;
        for (int i = 0; i < levels.length; i++){
            scoreToNextLevel = scoreToNextLevel+10;
            int id=i+1;
            levels[i]=new Level(id,scoreToNextLevel);
        }
    }

/**
    *Registers a new enemy to a certain level 
    *@param id Is the identifier of the enemy.
    *@param pointsGiven Is the number of points a player recieves after defeating the enemy.
    *@param pointsSubtracted the number of points that a player gets subtracted if the enemy defeats them.
    *@param lvl the level in which the enemy is going to be added.
    *@param i is the position of the entered level in the array level.
    *@param message is the message displayed after adding the Enemy.
    *@return a confirmation message
    */
    public String addEnemy(String id, int pointsGiven, int pointsSubtracted,int lvl, int enemyType){
    int i= lvl-1;
    String message=levels[i].addEnemy(id, pointsGiven, pointsSubtracted, enemyType);

        return message;
    }

/**
    *Registers a new treasure to a certain level 
    *@param name Is the name of the treasure.
    *@param imageURL Is the URL of the image of the treasure.
    *@param pointsIfFound the number of points that a player gets after finding the treasure.
    *@param lvl the level in which the treasure is going to be added.
    *@param message is the message displayed after adding the treasure.
    *@param i is the position of the entered level in the array level.
    *@return a confirmation message
    */
    public String addTreasure(String name, String imageURL, int pointsIfFound,int lvl){
        int i= lvl-1;
        String message=levels[i].addTreasure(name, imageURL, pointsIfFound);
        return message;
    }

/**
    *Modifies the points of a certain player 
    *@param nickname Is the identifier of the player.
    *@param points Is the number of points the player will recieve.
    *@param msg Is the message that will be displayed after the process is completed.
    *@return a confirmation message
    */
    public String changePoints(String nickname,int points){
        String msg= "Error";
        
        for (int i = 0; i < players.length; i++) {
            if(players[i]!=null && players[i].getNickname().equalsIgnoreCase(nickname)){
                players[i].setPoints(points);
                i=players.length;
                msg="The score has been changed"+nickname+"succesfully";
            }
            else{
                msg="The player does not exist";
            }
        }
        return msg;
    }

/**
    *Increases the level of a player 
    *@param nickname Is the identifier of the player.
    *@param msg Is the message that will be displayed after the process is completed.
    *@param lvl is the new level of the player
    *@return a confirmation message
    */
    public String levelUp(String nickname){
        String msg= "Error";
    
        for (int i = 0; i < players.length; i++) {
            if(players[i]!=null && players[i].getNickname().equalsIgnoreCase(nickname)){
                int lvl=players[i].getLvl();
                lvl=lvl+1;
                players[i].setLvl(lvl);
                i=players.length;
                msg="You have successfully leveled up, now "+nickname+" your level is: "+ lvl;
            }
            else{
                msg="The player does not exist";
            }
        }
        return msg;

    }

/**
    *Informs the treasures and enemies of a level 
    *@param msg1 Is the message with the treasure names.
    *@param msg2 Is the message with the enemy names.
    *@param msg Is the message that will be displayed after the process is completed.
    *@param lvl is the level to search.
    *@return a message with the treasures and enemies of the level
    */
    public String informTreasuresAndEnemies(int lvl){
        String msg= "Error";
        String msg1=levels[lvl-1].getTreasureNames();
        String msg2=levels[lvl-1].getEnemyNames();
        msg="Enemies of the level "+lvl+" are: "+msg2+" and the treasures are: "+msg1;
        return msg;
    }

/**
    *Informs the total number of a certain treasure in all the game 
    *@param treasureNum is the total number of the treasure in all the levels.
    *@param name is the name of the treasure to search.
    *@param msg Is the message that will be displayed after the process is completed.
    *@return a message with the number of treasures in the game.
    */
    public String numberOfTreasures(String name){
        String msg="";
        int treasureNum=0;
        for (int i = 0; i < levels.length; i++) {
            if(levels[i]!=null){
                treasureNum=treasureNum+levels[i].countNumberOfTreasures(name);
            }
        }
        msg= "There are "+treasureNum+" treasures "+name+"in the game";
        

        return msg;
    }
    
/**
    *Informs the total number of a certain treasure in all the game 
    *@param enemyNum is the total number of the enemy in all the levels.
    *@param name is the name of the treasure to search.
    *@param msg Is the message that will be displayed after the process is completed.
    *@return a message with the number of treasures in the game.
    */
    public String numberOfEnemies(String name){
        String msg="";
        int enemyNum=0;
        for (int i = 0; i < levels.length; i++) {
            if(levels[i]!=null){
                enemyNum=enemyNum+levels[i].countNumberOfEnemies(name);
            }
        }
        msg= "There are"+enemyNum+" enemies "+name+" in the game";
        

        return msg;
    }

/**
    *Most repeated treasure 
    *@param mostRepeated is most repeated treasure.
    *@param maxCount is the number of times the most repeated treasure appears.
    *@param nameToCompare Is the name of the treasure to count how many times it appears.
    *@param count is the number of times each treasure appears.
    *@return the name of the most repeated treasure.
    */
    public String mostRepeatedTreasure(){ 
        String mostRepeated="Error";
        int maxCount=0;
        
        String nameToCompare="";
        for (int i = 0; i < levels.length; i++) {

            for (int j = 0; j < levels[i].getTreasuresLength(); j++) {
                int count=0;
                if(levels[i].isRegistered(j)){
                    nameToCompare=levels[i].getTreasureName(j);
                    
                    for(int k=0; k<levels.length; k++ ){
                        for(int l=0; l<levels[k].getTreasuresLength(); l++){
                            if(levels[k].isRegistered(l)&& nameToCompare.equalsIgnoreCase(levels[k].getTreasureName(l))){
                                count++;
                            }
                        }
                    }
                    if(count>maxCount){
                        mostRepeated=nameToCompare;
                        maxCount=count;
                    }    
                }
            }   
            
        }
        return mostRepeated;
    }
    
/**
    *Biggest enemy 
    *@param biggestEnemy is the name of the biggest enemy.
    *@param maxCount is the number of points the biggest enemy appears.
    *@param lvl Is the level in which the bggest enemy is found.
    *@param msg Is the message that will be displayed after the process is completed.
    *@return the message informing the biggest enemy an its level.
    */
    public String biggestEnemy(){
        String msg="Error, no enemies registered";
        
        for (int i = 0; i < levels.length; i++) {
            for (int j = 0; j < levels[i].getEnemiesLength(); j++) {
                if(levels[i].isEnemyRegistered(j)){
                    
                    String biggestEnemy=levels[i].getEnemyName(j);
                    int maxCount=levels[i].getEnemyPointsGiven(j);
                    int lvl=i+1;
                    
                    for(int k=0; k<levels.length; k++ ){
                        for(int l=0; l<levels[k].getEnemiesLength(); l++){
                            if(levels[k].isEnemyRegistered(l)&& levels[k].getEnemyPointsGiven(l)>maxCount){
                                biggestEnemy=levels[k].getEnemyName(l);
                                maxCount=levels[k].getEnemyPointsGiven(l);
                                lvl=k+1;
                            }
                        }
                    }
                    msg="The enemy that awards the most points is "+biggestEnemy+" and is in the level: "+lvl;
                    j=levels[i].getEnemiesLength();
                }
                
            }   
        }
        return msg;
    }
    
/**
    *Consonants 
    *@param letter is each letter in the name of the enemy.
    *@param counter is the number of consonants in the names.
    *@param name Is the name of the enemy.
    *@param msg Is the message that will be displayed after the process is completed.
    *@return the message informing the number of consonants in the names of the registered enemies.
    */
    public String consonants(){
        String msg="Error";
        int counter=0;
        for(int i=0; i<levels.length; i++ ){
            for (int j = 0; j < levels[i].getEnemiesLength(); j++) {

                if(levels[i].isEnemyRegistered(j)){
                    String name= levels[i].getEnemyName(j);
                    for (int k = 0; k < name.length(); k++) {
                        char letter = name.charAt(k);
                        if (isConsonant(letter)) {
                            counter++;
                        }
                    } 
                }
            }
        } 
        msg="There are "+counter+" consonants in the names of enemies registered in the game";
        return msg;
    }

/**
    *Is Consonant 
    *@param isConsonant true if the variable letter is a consonant .
    *@param letter is a letter.
    *@return true if the letter given is consonant.
    */
    public boolean isConsonant(char letter) {
		boolean isConsonant="bcdfghjklmnpqrstvwxyz".contains(String.valueOf(letter).toLowerCase());
        return isConsonant;
	}

/**
    *Top 5 
    *@param letter is each letter in the name of the enemy.
    *@param points is the number of points a playr has.
    *@param top5arr Is an array containing the names of the top 5 players.
    *@param msg Is the message that will be displayed after the process is completed.
    *@return the message informing the top 5 players based on their points.
    */
    public String top5(){
        String msg="error";
        String [] top5arr = new String[5];
        for(int x=0; x<top5arr.length; x++){
            top5arr[x]="No registered players";
            for(int i=0; i<players.length; i++){
                if(players[i]!=null&& !players[i].getNickname().equalsIgnoreCase(top5arr[0])&& !players[i].getNickname().equalsIgnoreCase(top5arr[1])&& !players[i].getNickname().equalsIgnoreCase(top5arr[2])&& !players[i].getNickname().equalsIgnoreCase(top5arr[3])&& !players[i].getNickname().equalsIgnoreCase(top5arr[4])){
                    int points=players[i].getPoints();
                    top5arr[x]=players[i].getNickname();

                    for(int j=0; j<players.length; j++){
                        if(players[j]!=null&& !players[j].getNickname().equalsIgnoreCase(top5arr[0])&& !players[j].getNickname().equalsIgnoreCase(top5arr[1])&& !players[j].getNickname().equalsIgnoreCase(top5arr[2])&& !players[j].getNickname().equalsIgnoreCase(top5arr[3])&& !players[j].getNickname().equalsIgnoreCase(top5arr[4]) &&players[j].getPoints()>points){
                            points=players[j].getPoints();
                            top5arr[x]=players[j].getNickname();
                        }
                    }
                }          
            }        
        }            
        msg="Top 5 players \n1. "+top5arr[0]+"\n2. "+top5arr[1]+"\n3. "+top5arr[2]+"\n4. "+top5arr[3]+"\n5. "+top5arr[4];
        return msg;
    }
    //getters

/**
    *Gets the name of the Video Game
    *@param name Is the name of the game.
    *@return the name of the player
    */
    public String getName(){
		return name;
	}

/**
    *Gets the resolution in the x asis of the Video Game
    *@param resolutionX Is the resolution in the x asis of the game.
    *@return the resolution.
    */
    public int getResolutionX(){
		return resolutionX;
	}

/**
    *Gets the resolution in the y asis of the Video Game
    *@param resolutionX Is the resolution in the y asis of the game.
    *@return the resolution.
    */
    public int getResolutionY(){
		return resolutionY;
	}
    
    //setters

/**
    *Sets the name of the Video Game
    *@param name Is the name entered.
    */
    public void setName(String name){
		this.name=name;
	}
/**
    *Sets the resolution in the x asis of the Video Game
    *@param resolutionX Is the resolution entered.
    */
    public void setResolutionX(int resolutionX){
		this.resolutionX=resolutionX;
	}

/**
    *Sets the resolution in the y asis of the Video Game
    *@param resolutionY Is the resolution entered.
    */
    public void setResolutionY(int resolutionY){
		this.resolutionY=resolutionY;
	}
}