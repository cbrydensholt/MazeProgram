package com.company;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    static int[][] maze = {
            {2,0,1,1},
            {1,0,0,1},
            {1,1,1,1},
            {1,0,0,1},
            {1,1,1,1}



            //0 = wall
            //1 = path
            //2 = destination

            //x = column
            //y = row
            //vi starter øverst til højre. x = 3, y = 0

            //vi bruger stack til at lave vores maze, linkedlist i dette tilfælde. first in last out
            //to dimensionelt array ved at den har flere rows.
    };
    
   static LinkedList<Position> path = new LinkedList<Position>();

    public static void main(String[] args) {
        // write your code here
        Position p = new Position(0, 3); //indekser i en array

        path.push(p); //vi arbejder med stack, derfor bruger vi push, så p kommer forrest i vores stack. .add sætter den helt tilbage i starten


        while (true) {
            int currentY = path.peek().y;
            int currentX = path.peek().x;

            maze[currentY][currentX] = 0; //vores mest recent position, markeres som besøgt.



            if(isValid(currentY+1, currentX)){
                if (maze[currentY + 1][currentX] == 2) { //currentY+1 går en plads NEDAD, da y er row.
                    System.out.println("Moved down - You won gg");
                    return;
                } else if (maze[currentY + 1][currentX] == 1) {
                    System.out.println("Moved down");
                    path.push(new Position(currentY + 1, currentX)); //vi sætter den nye position som øverste position i vores stack.
                    //vi kan nemt refere til denne position da det er den øverste i bunken.
                    System.out.println(path.peek());
                    continue;
                }
            }


            if(isValid(currentY-1, currentX)){

                if (maze[currentY - 1][currentX] == 2) { //currentY+1 går en plads NEDAD, da y er row.
                    System.out.println("Moved up - You won gg");
                    return;
                } else if (maze[currentY - 1][currentX] == 1) {
                    System.out.println("Moved Up");
                    path.push(new Position(currentY - 1, currentX)); //vi sætter den nye position som øverste position i vores stack.
                    //vi kan nemt refere til denne position da det er den øverste i bunken.
                    System.out.println(path.peek());
                    continue;
                }

            }


            if(isValid(currentY, currentX-1)){
                if (maze[currentY][currentX - 1] == 2) { //currentY+1 går en plads NEDAD, da y er row.
                    System.out.println("Moved left - You won gg");
                    return;
                } else if (maze[currentY][currentX - 1] == 1) {
                    System.out.println("Moved Left");
                    path.push(new Position(currentY, currentX - 1)); //vi sætter den nye position som øverste position i vores stack.
                    //vi kan nemt refere til denne position da det er den øverste i bunken.
                    System.out.println(path.peek());
                    continue;
                }
            }

            if(isValid(currentY, currentX+1)){
                if (maze[currentY][currentX + 1] == 2) { //currentY+1 går en plads NEDAD, da y er row.
                    System.out.println("Moved right - You won gg");
                    return;
                } else if (maze[currentY][currentX + 1] == 1) {
                    System.out.println("Moved right");
                    path.push(new Position(currentY, currentX + 1)); //vi sætter den nye position som øverste position i vores stack.
                    //vi kan nemt refere til denne position da det er den øverste i bunken.
                    System.out.println(path.peek());
                    continue;
                }
            }

            path.pop();
            if (path.size() < 0) { //fjerner koordinat fra stack. Siden alle besøgte sættes som 0, kommer vi ikke tilbage hertil
                System.out.println("No Path");
            }
        }
    }
        public static boolean isValid(int y, int x){
            if(y < 0 //kan ikke være under 0 rækker
                    || y>=maze.length //kan ikke være et koordinat der går ud over antallet af rækker
                    || x<0 //kan ikke være under 0 columns
                    || x>=maze[y].length //den må ikke være mere end antallet af rækker.

            ) { //Hvis vores placering er udenfor vores maze. Length er ikke det samme som antal indeks.

                return false;


            }

            return true;

        }

    }
