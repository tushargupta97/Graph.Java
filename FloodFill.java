import java.util.*;
public class FloodFill {
    public static void helper(int [][] img, int sr, int sc, int color, boolean vis[][],int orgCol){ //O{m*n}
        if(sr<0|| sc<0||sr>=img.length||sc>=img[0].length ||vis[sr][sc] || img[sr][sc]!=orgCol){
            return ;
        }

        img[sr][sc]=color;
        //left
        helper( img, sr, sc-1, color, vis, orgCol);
        //right
        helper( img, sr, sc+1, color, vis, orgCol);
        //up
        helper( img, sr-1, sc, color, vis, orgCol);
        //down
        helper( img, sr+1, sc, color, vis, orgCol);
    }
    public static int[][] floodFill(int [][] img, int sr, int sc, int color){
        boolean [][]vis= new boolean[img.length][img[0].length];
        helper(img, sr, sc, color, vis, img[sr][sc]);
        return img;
    }

    public static void main(String[] args) {
        int img[][]={{1,1,1},{1,1,0},{1,0,1}};
        int sr=1,sc=1,color=2;
        System.out.println(floodFill(img,sr,sc,color));
    }
}
