/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gameoflife;

/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht
 * als zyklisch geschlossen betrachtet wird.
 *
 * @author Holger Vogelsang
 */
public class GameOfLifeLogic {
    /**
     * population[rows][columns][old/new generation] old false - new true
     */
    private boolean[][][] population;
    private int activePopulation;
    private int followingPopulation;
    
     

	public void setStartGeneration(boolean[][] generation) {
            int x = generation.length;
            int y = generation[0].length;
            activePopulation = 0;
            followingPopulation = 1;
            
            population = new boolean[x][y][2];
            
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    population[i][j][activePopulation] = generation[i][j];
                    population[i][j][followingPopulation] = population[i][j][activePopulation];
                }
            }
	}
       
	public void nextGeneration() {
            int x = population.length;
            int y = population[0].length;
            
            
            
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    if(population[i][j][activePopulation] && !(neighbours(i,j,population) == 2 ||
                            neighbours(i,j,population) == 3)){
                        population[i][j][followingPopulation] = false;
                    }
                    else if(!population[i][j][activePopulation] && (neighbours(i,j,population) == 3)){
                       population[i][j][followingPopulation] = true;
                    }
                    else if(population[i][j][activePopulation] && 
                            ((neighbours(i,j,population) >= 4)||(neighbours(i,j,population) <= 1))){
                       population[i][j][followingPopulation] = false;
                    }
                }
            }
            
            //boolean[][][] helpField = new boolean[x][y][2];
            
            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    population[i][j][activePopulation] = population[i][j][followingPopulation];
                }
            }
            /*
            int help = followingPopulation;
            followingPopulation = activePopulation;
            activePopulation = help;
            */
	}
        
        public int neighbours(int x, int y, boolean[][][] population){
            int counter = 0;
            
            int[][] neighbours = {
                                    {x+1,y  },{x-1,y  },
                                    {x+1,y+1},{x-1,y+1},
                                    {x+1,y-1},{x-1,y-1},
                                    {x  ,y-1},{x  ,y+1}
            };
            
            for(int i[]: neighbours){
                try{
                    if(population[i[0]][i[1]][activePopulation] == true){
                        counter++;
                    }
                }
                catch(ArrayIndexOutOfBoundsException e){}
            }
            return counter;
            
            /*
            switch(counter){
                case 1:     return false;
                case 2:     return true;    
                case 3:     return true;   
                case 4:     return false;
                case 5:     return false;
                case 6:     return false;
                case 7:     return false;
                case 8:     return false;
                default:    return false; 
            }*/
        }

	public boolean isCellAlive(int x, int y) {
            return population[x][y][activePopulation];
	}
}