package model;
public class Player{
    //attributes
	private String nickname;
	private String name;
    private int points=10;
	private int lives=5;
    private int lvl=1;

	//relations
	//private Level[] levels; 

	//methods
/** 
    *Creats the object player 
    *@param nickname Is the unique id of the new player.
    *@param name is the name of the player
    *@param points The number of points that this player has.
    *@param lives The number of lives that a player has.
    *@param lvl The level of a player.
    */
    public Player(String nickname, String name, int points, int lives, int lvl){
        this.nickname=nickname;
		this.name= name;
        this.points= points;
        this.lives= lives;
		this.lvl= lvl;
    }

    //getters

/**
    *Gets the nickname of the player
    *@param nickname Is the nickname of the player.
    *@return the nickname.
    */
    public String getNickname(){
		return nickname;
	}

/**
    *Gets the name of the player
    *@param name Is the name of the player.
    *@return the name.
    */
    public String getName(){
		return name;
	}

/**
    *Gets the points of the player
    *@param points Is the number of points of the player.
    *@return the points.
    */
    public int getPoints(){
		return points;
	}

/**
    *Gets the lives of the player
    *@param lives Is the number of lives of the player.
    *@return the lives.
    */
    public int getLives(){
		return lives;
	}

/**
    *Gets the level of the player
    *@param lvl Is the level of the player.
    *@return the level.
    */
    public int getLvl(){
		return lvl;
	}

    //setters

/**
    *Sets the nickname of the player
    *@param nickname Is the entered nickname.
    */
    public void setNickname(String nickname){
		this.nickname=nickname;
	}

/**
    *Sets the name of the player
    *@param nickname Is the entered name.
    */
    public void setName(String name){
		this.name=name;
	}

/**
    *Sets the points of the player
    *@param points Is the number of points entered.
    */
    public void setPoints(int points){
		this.points=points;
	}

/**
    *Sets the lives of the player
    *@param lives Is the number of lives entered.
    */
    public void setLives(int lives){
		this.lives=lives;
	}

/**
    *Sets the level of the player
    *@param lvl Is the level entered.
    */
    public void setLvl(int lvl){
		this.lvl=lvl;
	}
}