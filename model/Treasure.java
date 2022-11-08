package model;
public class Treasure{
    
    //attributes
	private String name;
	private String imageURL;
    private int pointsIfFound;
	private int positionX=(int)(Math.random()*640+1);
    private int positionY=(int)(Math.random()*480+1);
	//relations
	
	//methods

/** 
    *Creats the object Treasure 
    *@param name Is the name of the treasure.
    *@param imageURL Is the URL of the image of the treasure.
    *@param pointsIfFound the number of points that a player gets after finding the treasure.
	*/
    public Treasure(String name, String imageURL, int pointsIfFound){
        this.name=name;
		this.imageURL= imageURL;
		this.pointsIfFound= pointsIfFound;
    }

    //getters

/**
    *Gets the name of the Treasure
    *@param name Is the name of the treasure.
    *@return the name. 
    */
    public String getName(){
		return name;
	}

/**
    *Gets the image URL of the Treasure
    *@param imageURL Is the image URL of the treasure.
    *@return the image URL.
    */
    public String getImageURL(){
		return imageURL;
	}

/**
    *Gets the number of points If Found of the Treasure
    *@param pointsIfFound Is the number of point the treasure gives when found.
    *@return the points if found.
    */
    public int getPointsIfFound(){
		return pointsIfFound;
	}

/**
    *Gets the x cordenate of the treasure
    *@param positionX Is the x cordenate of the treasure.
    *@return the position.
    */
    public int getPositionX(){
		return positionX;
	}

/**
    *Gets the y cordenate of the treasure
    *@param positionY Is the y cordenate of the treasure.
    *@return the position.
    */
    public int getPositionY(){
		return positionY;
	}

    //setters
/**
    *Sets the name of the Treasure
    *@param name Is the name of the treasure.
    */
    public void setName(String name){
		this.name=name;
	}

/**
    *Sets the image URL of the Treasure
    *@param imageURL Is the image URL of the treasure.
    */
    public void setImageURL(String imageURL){
		this.imageURL=imageURL;
	}

/**
    *Sets the number of points If Found of the Treasure
    *@param pointsIfFound Is the number of point the treasure gives when found.
    */
    public void setPointsIfFound(int pointsIfFound){
		this.pointsIfFound=pointsIfFound;
	}

/**
    *Sets the x cordenate of the treasure
    *@param positionX Is the x cordenate of the treasure.
    */
    public void setPositionX(int positionX){
		this.positionX=positionX;
	}

/**
    *Sets the y cordenate of the treasure
    *@param positionY Is the y cordenate of the treasure.
    */
    public void setPositionY(int positionY){
		this.positionY=positionY;
	}
}