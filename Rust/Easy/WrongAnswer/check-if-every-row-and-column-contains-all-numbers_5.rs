impl Solution {
    pub fn check_valid(matrix: Vec<Vec<i32>>) -> bool {
        
        let n = matrix.len();
        let mut rows = vec![0; n];
        let mut cols = vec![0; n];
        for i in 0..n {
            for j in 0..n {
                rows[i] |= 1 << matrix[i][j];
                cols[j] |= 1 << matrix[i][j];
            }
        }
        for i in 0..n {
            if rows[i] != (1 << n + 1) - 2 || cols[i] != (1 << n + 1) - 2 {
                return false;
            }
        }
        true
    }
}