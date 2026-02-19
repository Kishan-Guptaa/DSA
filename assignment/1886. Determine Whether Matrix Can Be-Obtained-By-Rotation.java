class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        
        for (int k = 0; k < 4; k++) {
            
            if (isEqual(mat, target)) {
                return true;
            }
            
            rotate(mat);
        }
        
        return false;
    }
    
    private void rotate(int[][] mat) {
        int n = mat.length;
       
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        
       
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }
    
    
    private boolean isEqual(int[][] mat, int[][] target) {
        int n = mat.length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}





// class Solution {
//     public boolean findRotation(int[][] mat, int[][] target) {
//         int n = mat.length;
        
//         boolean r0 = true;    // 0 degree
//         boolean r90 = true;   // 90 degree
//         boolean r180 = true;  // 180 degree
//         boolean r270 = true;  // 270 degree
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
                
//                 if (mat[i][j] != target[i][j]) {
//                     r0 = false;
//                 }
                
//                 if (mat[n - j - 1][i] != target[i][j]) {
//                     r90 = false;
//                 }
                
//                 if (mat[n - i - 1][n - j - 1] != target[i][j]) {
//                     r180 = false;
//                 }
                
//                 if (mat[j][n - i - 1] != target[i][j]) {
//                     r270 = false;
//                 }
//             }
//         }
        
//         return r0 || r90 || r180 || r270;
//     }
// }
