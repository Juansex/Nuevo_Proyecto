package model;
public class Level{
    //attributes
	private int id;
	private int scoreToNextLevel;
     
    
	//relations
	private Treasure[] treasures;
    private Enemy[] enemies;

	//methods

/** 
    *Creats the object Level 
    *@param id Is the unique id of the new player.
    *@param scoreToNextLevel is the number of points a player must reach to advance level.
    *@param enemies is the array containing the levels of the game.
    *@param treasures is the array containing the treasures of the game.
    */
    public Level(int id, int scoreToNextLevel){
        this.id=id;
		this.scoreToNextLevel= scoreToNextLevel;
        enemies= new Enemy[5];
        treasures= new Treasure[10];
    }

/**
    *Registers a new enemy to this level 
    *@param id Is the identifier of the enemy.
    *@param pointsGiven Is the number of points a player recieves after defeating the enemy.
    *@param pointsSubtracted the number of points that a player gets subtracted if the enemy defeats them.
    *@param objEnemy is an object enemy.
    *@param available indicates if there is an available space in the array to save the enemy.
    *@param message is the message displayed after adding the Enemy.
    *@return a confirmation message
    */
    public String addEnemy(String id, int pointsGiven, int pointsSubtracted, int type){
        String message="Error";
        if (searchEnemy(id)){
            Enemy objEnemy= new Enemy(id, pointsGiven, pointsSubtracted, type);

            for (int i = 0; i < enemies.length; i++) {
                if(enemies[i]==null){
                    enemies[i]= objEnemy;
                    i=enemies.length;
                    message="Enemy successfully saved in the level";
                }
                else{
                    message="No spaces available to save this enemy";
                }
            }	  
		}
        else {
            message="This enemy is already registered at this level";
        }
        return message;
    }

/** 
    *Looks for an enemy nickname inside the enemy array 
    *@param id Is the unique id of the enemy.
    *@param isAvailable shows if there is an available space for the enemy or not.
    *@return true if the id is available
    */
    public boolean searchEnemy(String id){
        boolean isAvailable=true;
        for (int i = 0; i < enemies.length; i++) {
            if(isAvailable && enemies[i]!=null && enemies[i].getId().equalsIgnoreCase(id)){
                isAvailable=false;
            }
        }
        return isAvailable;
    }

/**
    *Registers a new treasure to this level 
    *@param name Is the name of the treasure.
    *@param imageURL Is the URL of the image of the treasure.
    *@param pointsIfFound the number of points that a player gets after finding the treasure.
    *@param objTreasure Is the object that will be created.
    *@param message is the message displayed after adding the treasure.
    *@param available shows if there is an available space for the treasure or not.
    *@return a confirmation message
    */
    public String addTreasure(String name, String imageURL, int pointsIfFound){
        String message="Error";
        Treasure objTreasure= new Treasure(name, imageURL, pointsIfFound);

            for (int i = 0; i < treasures.length; i++) {
                if(treasures[i]==null){
                    treasures[i]= objTreasure;
                    i=treasures.length;
                    message="Treasure successfully saved in the level";
                }
                else{
                    message="There is no space available to store this treasure";
                }
            }	  
        return message;
    }


    //getters

/**
    *Gets the id of the level
    *@param id Is the id of the level.
    *@return the id
    */
    public int getId(){
		return id;
	}

/**
    *Gets the length of the treasure
    *@param treasureslength Is the length of the array.
    *@return the length of the treasure array
    */
    public int getTreasuresLength(){
        int treasureslength=treasures.length;
		return treasureslength;
	}

/**
    *Gets the length of the enemies array
    *@param enemiesLength Is the length of the array.
    *@return the length of the enemies array
    */
    public int getEnemiesLength(){
        int enemiesLength=enemies.length;
		return enemiesLength;
	}

/**
    *Gets the score neede To advance Level of this level
    *@param scoreToNextLevel Is the score neede To advance Level of the level.
    *@return the score to the next level
    */
    public int getScoreToNextLevel(){
		return scoreToNextLevel;
	}

/**
    *Gets the name of the treasures
    *@param treasureNames Is the names of the treasures.
    *@return the names of the treasures of the level.
    */
    public String getTreasureNames(){
		String treasureNames="No registered treasures";
        if(treasures[0]!=null){
            treasureNames=treasures[0].getName();
        }
        for(int i=1; i < treasures.length; i++){
            if(treasures[i]!=null){
                treasureNames=treasureNames+ ", " +treasures[i].getName();
            }
        }
        return treasureNames;
    }

/**
    *Gets the names of the enemies 
    *@param enemyNames Is the names of the enemies.
    *@return the names of the enemies of the level.
    */
    public String getEnemyNames(){
		String enemyNames="No registered enemies";
        if(enemies[0]!=null){
            enemyNames=enemies[0].getId();
        }
        for(int i=1; i < enemies.length; i++){
            if(enemies[i]!=null){
                enemyNames=enemyNames+ ", " +enemies[i].getId();
            }
        }
        return enemyNames;
    }
    
/**
    *Is enemy registered 
    *@param isRegistered indicates if the enemy is arleady registred.
    *@return true if the enemy is registered.
    */    
    public boolean isEnemyRegistered(int j){
        boolean isRegistered=true;
        if(enemies[j]==null){
            isRegistered=false;
        }
        return isRegistered;
    }

/**
    *Is registered 
    *@param isRegistered indicates if the enemy is arleady registred.
    *@return true if the enemy is registered.
    */    
    public boolean isRegistered(int j){
        boolean isRegistered=true;
        if(treasures[j]==null){
            isRegistered=false;
        }
        return isRegistered;
    }
    
/**
    *Get treasure name 
    *@param treasureName is the name of the treasure.
    *@return the name of the treasure.
    */  
    public String getTreasureName(int j){
		String treasureName="No registered treasures";
                treasureName=treasures[j].getName();
        return treasureName;
    }

/**
    *Get enemy name 
    *@param enemyName is the name of the enemy.
    *@return the name of the enemy.
    */  
    public String getEnemyName(int j){
		String enemyName="No registered enemies";    
        enemyName=enemies[j].getId();       
        return enemyName;
    }

/**
    *Get enemy points 
    *@param pointsGiven is the points that the enemy gives.
    *@return the points that the enemy gives.
    */  
    public int getEnemyPointsGiven(int j){
        int pointsGiven=0;
        pointsGiven=enemies[j].getPointsGiven();
        return pointsGiven;
    }

/**
    *Count number of treasures 
    *@param treasureNum is the number of treasures in the level.
    *@return the number of treasures in the level.
    */      
    public int countNumberOfTreasures(String name){
		int treasureNum=0;
        for (int i = 0; i < treasures.length; i++) {
            if(treasures[i]!=null && treasures[i].getName().equalsIgnoreCase(name)){
                treasureNum=treasureNum+1;
            }
        }
        return treasureNum;
    }

/**
    *Count number of enemies 
    *@param enemyNum is the number of enemies in the level.
    *@return the number of enemies in the level.
    */      
    public int countNumberOfEnemies(String name){
		int enemyNum=0;
        for (int i = 0; i < enemies.length; i++) {
            if(enemies[i]!=null && enemies[i].getId().equalsIgnoreCase(name)){
                enemyNum=enemyNum+1;
            }
        }
        return enemyNum;
    }
    

    //setters
/**
    *Sets the id of the level
    *@param id Is the id entered.
    */
    public void setId(int id){
		this.id=id;
	}

/**
    *Sets the score neede To advance Level of this level
    *@param scoreToNextLevel Is the score neede To advance Level entered.
    */
    public void setScoreToNextLevel(int scoreToNextLevel){
		this.scoreToNextLevel=scoreToNextLevel;
	}
}