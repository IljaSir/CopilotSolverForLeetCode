impl Solution {
    pub fn is_toeplitz_matrix(matrix: Vec<Vec<i32>>) -> bool {
        
        for i in 0..matrix.len() - 1 {
            for j in 0..matrix[0].len() - 1 {
                if matrix[i][j] != matrix[i + 1][j + 1] {
                    return false;
                }
            }
        }
        true
    }
}