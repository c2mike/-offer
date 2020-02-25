package cn.mayun.jianzhioffer66;

public class Solution1 {
    public boolean Find(int target, int [][] array) {
        if(array==null)
        {
            return false;
        }
        if(array.length==1)
        {
            return find(array[0], target);
        }
        int rows = array.length - 1;
        int cols = array[0].length - 1;
        if(array[0][cols]<target)
        {
            int[][] copy = copy(1,0,rows,cols,array);
            return Find(target, copy);
            // for(int i=0;i<=rows;i++)
            // {
            //     if(array[i][cols]==target)
            //     {
            //         return true;
            //     }
            // }
            // return false;
        }
        else if(array[0][cols]>target)
        {
            int[][] copy = copy(0, 0, rows, cols-1, array);
            return Find(target, copy);
        }
        else{
            return true;
        }

    }
    
    private int[][] copy(int x1,int y1, int x2, int y2,int[][] array)
    {
        if(x1>x2||y1>y2)
        {
            return null;
        }
        int[][] result = new int[x2-x1+1][y2-y1+1];
        for(int i =0;i<x2-x1+1;i++)
        {
            for(int j = 0;j<y2-y1+1;j++)
            {
                result[i][j] = array[x1+i][y1+j];
            }
        }
        
        return result;
    }

    private boolean find(int[] array,int target)
    {
        int start = 0, end = array.length-1;
        int mid = start + (end - start )/2;
        while(start <= end)
        {
            if(target<array[mid])
            {
                end = mid - 1;
                mid = start + (end - start )/2;
                
            }
            else if(target>array[mid])
            {
                start = mid + 1;
                mid = start + (end - start )/2;

            }
            else{
                return true;
            }
        }
        return false;
    }

    //方法2
    public boolean Find2(int target, int [][] array) {
        if(array==null)
        {
            return false;
        }
        int x = 0, y = array[0].length-1;
        while(x<=array.length-1&&y>=0)
        {
            int t = array[x][y];
            if(target>t)
            {
                x++;
            }
            else if(target<t)
            {
                y--;
            }
            else{
                return true;
            }
        }
        return false;
    }
}