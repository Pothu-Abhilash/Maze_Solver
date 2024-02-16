/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author nithi
 */
public class MazeSolver extends JFrame{
    
    
    // 0's are empty space
    // 1's blocked way
    // 9 target element
    // 2 visited 
    
    private int[][] maze ={
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,0,0,1},
        {1,0,0,1,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
   public ArrayList<Integer> path = new ArrayList<>();
   private int pathIndex = 0;
   
   
   public MazeSolver(){
       setTitle("Maze Solver");
       setSize(540, 480);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       DepthFirstSearch.searchPath(maze, 1, 1, path);
        pathIndex = path.size() - 2;
   }
   
   
   public void paint(Graphics g){
       
       g.translate(50, 50);
       for(int i = 0 ; i < maze.length; i++)
       {
           for(int j = 0; j < maze[0].length; j++)
           {
               Color color;
               switch(maze[i][j]){
                   case 1: color = Color.BLACK;break;
                   case 9: color = Color.RED;break;
                   default : color = Color.white;break;
               }
               g.setColor(color);
               g.fillRect(j*30, 30*i, 30, 30);
               g.setColor(Color.black);
               g.drawRect(j*30, 30*i, 30, 30);
           }
       }
       
       
       // painting the path with green color
       for(int p = 0; p < path.size(); p += 2)
       {
           int pathX = path.get(p);
           int pathY = path.get(p + 1);
           g.setColor(Color.green);
           g.fillRect(30* pathX, 30 * pathY, 20, 20);
       }
       
       
   }
   public static void main(String[]args)
   {
       MazeSolver view = new MazeSolver();
       view.setVisible(true);
   }
}
