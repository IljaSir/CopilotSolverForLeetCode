impl Solution {
    pub fn rotate(matrix: &mut Vec<Vec<i32>>) {
        

        let n = matrix.len();
        for i in 0..n {
            for j in 0..i {
                matrix[i][j] ^= matrix[j][i];
                matrix[j][i] ^= matrix[i][j];
                matrix[i][j] ^= matrix[j][i];
            }
        }
        for i in 0..n {
            for j in 0..n / 2 {
                matrix[i][j] ^= matrix[i][n - j - 1];
                matrix[i][n - j - 1] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][n - j - 1];
            }
        }