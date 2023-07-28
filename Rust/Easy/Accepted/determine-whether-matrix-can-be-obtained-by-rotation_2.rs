impl Solution {
    pub fn find_rotation(mat: Vec<Vec<i32>>, target: Vec<Vec<i32>>) -> bool {
        
        let n = mat.len();
        let mut mat = mat;
        for _ in 0..4 {
            for i in 0..n {
                for j in i+1..n {
                    mat[i][j] ^= mat[j][i];
                    mat[j][i] ^= mat[i][j];
                    mat[i][j] ^= mat[j][i];
                }
            }
            for i in 0..n {
                for j in 0..n/2 {
                    mat[i][j] ^= mat[i][n-1-j];
                    mat[i][n-1-j] ^= mat[i][j];
                    mat[i][j] ^= mat[i][n-1-j];
                }
            }
            if mat == target {
                return true;
            }
        }
        false
    }
}