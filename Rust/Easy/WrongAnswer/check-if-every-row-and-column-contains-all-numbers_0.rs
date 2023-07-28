impl Solution {
    pub fn check_valid(matrix: Vec<Vec<i32>>) -> bool {
        
        let n = matrix.len();
        let mut row = vec![0; n];
        let mut col = vec![0; n];
        for i in 0..n {
            for j in 0..n {
                row[i] |= 1 << matrix[i][j];
                col[j] |= 1 << matrix[i][j];
            }
        }
        for i in 0..n {
            if row[i] != (1 << (n + 1)) - 2 || col[i] != (1 << (n + 1)) - 2 {
                return false;
            }
        }
        true
    }
}