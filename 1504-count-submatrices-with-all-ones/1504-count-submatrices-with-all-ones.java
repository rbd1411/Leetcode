class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int rectangleCount = 0;

        // Process each row as the "bottom" of potential submatrices
        for (int i = 0; i < rows; i++) {
            // Step 1: Build histogram heights in-place
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1 && i > 0) {
                    // If current cell is 1, extend height from row above
                    mat[i][j] += mat[i - 1][j];
                }
            }

            // Step 2: For each column, count rectangles ending at this row
            for (int j = 0; j < cols; j++) {
                int minHeight = mat[i][j];

                // Scan leftwards to include submatrices ending at (i, j)
                for (int k = j; k >= 0 && minHeight > 0; k--) {
                    minHeight = Math.min(minHeight, mat[i][k]);
                    rectangleCount += minHeight;
                }
            }
        }

        return rectangleCount;
    }
}