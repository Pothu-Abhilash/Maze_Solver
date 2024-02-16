/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;
import java.util.*;
/**
 *
 * @author nithi
 */
public class DepthFirstSearch {
    // If path was found, this method will return true
    //and the path list will be filled
    // x and y are the starting searching positions
    
    public static boolean searchPath(int[][]maze, int x, int y, ArrayList<Integer> path)
    {
        if(maze[y][x] == 9)
        {
            path.add(x);
            path.add(y);
            return true;
        }
        
        
        if(maze[y][x] == 0)
        {
            maze[y][x] = 2;
            
            // now let's visit all neighbor nodes recursivly
            // If path was found, let's fill the path with current position
            
            int dx = -1;
            int dy = 0;
            if(searchPath(maze, x + dx, y + dy, path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx = 1;
            dy = 0;
            if(searchPath(maze, x + dx, y + dy, path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx = 0;
            dy = 1;
            if(searchPath(maze, x + dx, y + dy, path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx = 0;
            dy = -1;
            if(searchPath(maze, x + dx, y + dy, path))
            {
                path.add(x);
                path.add(y);
                return true;
            }
        }
        return false;
    }
}
