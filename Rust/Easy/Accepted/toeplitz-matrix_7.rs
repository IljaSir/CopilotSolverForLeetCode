impl Solution {
    pub fn is_toeplitz_matrix(matrix: Vec<Vec<i32>>) -> bool {
        
        let mut matrix = matrix;
        for i in 0..matrix.len() {
            for j in 0..matrix[i].len() {
                if i > 0 && j > 0 && matrix[i-1][j-1] != matrix[i][j] {
                    return false;
                }
            }
        }
        true
    }
}