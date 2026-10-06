class Solution {
    int[] row={0,0,1,-1};
    int[] col={1,-1,0,0};
    public int minFlips(int[][] mat) {
        boolean ok=true;
        int n=mat.length;
        int m=mat[0].length;
        boolean[][] visited=new boolean[n][m];
        int ans= solve(mat,n,m,visited);
        if(ans>=Integer.MAX_VALUE-1)return -1;
        return ans;
    }
    public int solve(int[][] mat,int n,int m,boolean[][] visited){
        int ans=Integer.MAX_VALUE-1;
         if(check(mat,n,m)==true)return 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                   if(!visited[i][j]){
                       flip(mat,i,j,n,m);
                       visited[i][j]=true;
                   int count=solve(mat,n,m,visited);
                     ans=Math.min(ans,count+1);
                      flip(mat,i,j,n,m); // backtrack
                     visited[i][j]=false; // backtrack
                   }
                }
            }
        return ans;
    }
// flip current cell and neighbour node.
    public void flip(int[][] mat,int i,int j,int n,int m){
            mat[i][j]=mat[i][j]^1;
             for(int r=0;r<4;r++){
                int x=i+row[r];
                int y=j+col[r];
                if(x<0 || y<0 || x>=n || y>=m)continue;
                mat[x][y]=mat[x][y]^1;
             }
    }
// check if there is no 1 in the matrix.
    public boolean check(int[][] mat,int n,int m){
          for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               if(mat[i][j]==1)return false;
            }
        }
        return true;
    }
}