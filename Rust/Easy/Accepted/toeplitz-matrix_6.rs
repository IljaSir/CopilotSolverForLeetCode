impl Solution {
    pub fn is_toeplitz_matrix(matrix: Vec<Vec<i32>>) -> bool {
        
        for i in 0..matrix.len() {
            for j in 0..matrix[i].len() {
                if i > 0 && j > 0 && matrix[i][j] != matrix[i-1][j-1] {
                    return false;
                }
            }
        }
        true
    }
}