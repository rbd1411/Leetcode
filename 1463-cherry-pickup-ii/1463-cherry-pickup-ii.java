class Solution {

    private int helper(int[][] grid, int rows, int cols){

        int[][] front = new int[cols][cols];

        // Base Case :-
        for(int j1 = 0; j1 < cols; j1++){
            for(int j2 = 0; j2 < cols; j2++){
                if(j1 == j2){
                    front[j1][j2] = grid[rows-1][j1];
                }else{
                    front[j1][j2] = grid[rows-1][j1] + grid[rows-1][j2];
                }
            }
        }

        for(int i = rows - 2; i >= 0; i--){
            int[][] curr = new int[cols][cols];

            for(int j1 = 0; j1 < cols; j1++){
                for(int j2 = 0; j2 < cols; j2++){
                    int maxi = Integer.MIN_VALUE;

                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){

                            int value;
                            if(j1 == j2){
                                value = grid[i][j1];
                            }else{
                                value = grid[i][j1] + grid[i][j2];
                            }

                            if(j1 + dj1 >= 0 && j1 + dj1 < cols &&
                                j2 + dj2 >= 0 && j2 + dj2 < cols) {
                                    value += front[j1 + dj1][j2 + dj2];
                            }else{
                                value += Integer.MIN_VALUE;
                            }

                            maxi = Math.max(maxi, value);
                        }
                    }

                    curr[j1][j2] = maxi;
                }
            }

            front = curr;
        }

        return front[0][cols-1];
    }

    public int cherryPickup(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        return helper(grid, rows, cols);
    }
}