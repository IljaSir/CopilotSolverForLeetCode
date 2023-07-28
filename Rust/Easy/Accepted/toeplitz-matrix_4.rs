impl Solution {
    pub fn is_toeplitz_matrix(matrix: Vec<Vec<i32>>) -> bool {
        
        let m = matrix.len();
        let n = matrix[0].len();
        for i in 0..m {
            for j in 0..n {
                if i > 0 && j > 0 && matrix[i-1][j-1] != matrix[i][j] {
                    return false;
                }
            }
        }
        true
    }
}