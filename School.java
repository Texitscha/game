
public class School extends Buildings
{
    public int multiplicator;
    
    public School(View view, String name, int costsWood, int costsClay, int costsIron, int costsGold, int costsPeople)
    {
        super(view, name, costsWood, costsClay, costsIron, costsGold, costsPeople, 0, 0, 0, 0, 0);
        this.multiplicator=2000;
    }
    
    
    //TODO levelUp!!! Jonas?
    /*public void levelUp(int oldLevel, int newLevel)
    {
        if(this.amount<1) return;
        
        // for costs
        

        // for plus
        
        
    }*/

    // method is called if the user wants to build a new building, checked if enough materials available (if not return false), calculates the plus 
    // for unique buildings newBuild = a level up
    // plusGoldCastle is taken from the castle object to calculate the amount of gold added
    // schoolMultiplicator is taken from special1 of the School Object and is used to calculate the time needed to build something new/level up
    public void newBuild(int wood, int clay, int iron, int gold, int people)
    {

    	if(this.costsWood<4||this.costsClay<2||this.costsIron<0||this.costsGold<3||this.costsPeople<2)
    	{
    		view.addText("You can't build anything!");
    		view.addText("GAME OVER!");
    	}
    	
        if(wood-this.costsWood<0||clay-this.costsClay<0||iron-this.costsIron<0||gold-this.costsGold<0||people-this.costsPeople<0)
        {
            view.addText("You do not have enough resources.\n"); 
            return;
        }

        wood=wood-this.costsWood;
        clay=clay-this.costsClay;
        iron=iron-this.costsIron;
        gold=gold-this.costsGold;
        people=people-this.costsPeople;

        //isnt�t needed for now
        //view.addText("Wait until the building has been created.\n");

        learningWait(this.multiplicator, this.costsPeople);
        wood=wood+this.plusWood;
        clay=clay+this.plusClay;
        iron=iron+this.plusIron;
        gold=gold+this.plusGold;
        people=people+this.plusPeople;

        this.multiplicator-=100;
        if(this.multiplicator<0) this.multiplicator=50;

        this.amount++;

        User.materials[0]=wood;
        User.materials[1]=clay;
        User.materials[2]=iron;
        User.materials[3]=gold;
        User.materials[4]=people;

        view.addText("The SCHOOL has leveled up.\n");
        CasePrintouts.resources(view);
    }

    public int getMultiplicator()
    {
        return this.multiplicator;
    }
    
    // method is used to get info about costs and plus of creating the building
    public void getInfo()
    {
    	view.addText("Costs:\n\tWood:\t"+this.costsWood+"\n\tClay:\t"+this.costsClay+"\n\tIron: \t"+this.costsIron+"\n\tGold:\t"+this.costsGold+"\n\tPeople:\t"+this.costsPeople+"\n");
        view.addText("Plus:\n\tWood:\t"+this.plusWood+"\n\tClay:\t"+this.plusClay+"\n\tIron:\t"+this.plusIron+"\n\tGold:\t"+this.plusGold+"\n\tPeople:\t"+this.plusPeople+"\n");
        view.addText("Amount:\t"+this.amount+"\n\n");
    }
}
