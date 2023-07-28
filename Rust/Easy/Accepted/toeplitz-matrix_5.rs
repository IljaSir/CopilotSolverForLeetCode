impl Solution {
    pub fn is_toeplitz_matrix(matrix: Vec<Vec<i32>>) -> bool {
        
        let (m, n) = (matrix.len(), matrix[0].len());
        for i in 0..m {
            for j in 0..n {
                if i > 0 && j > 0 && matrix[i][j] != matrix[i-1][j-1] {
                    return false;
                }
            }
        }
        true
    }
}