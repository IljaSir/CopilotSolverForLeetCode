impl Solution {
    pub fn check_valid(matrix: Vec<Vec<i32>>) -> bool {
        
        let mut rows = vec![vec![false; matrix.len()]; matrix.len()];
        let mut cols = vec![vec![false; matrix.len()]; matrix.len()];
        for i in 0..matrix.len() {
            for j in 0..matrix.len() {
                rows[i][matrix[i][j] as usize - 1] = true;
                cols[j][matrix[i][j] as usize - 1] = true;
            }
        }
        for i in 0..matrix.len() {
            for j in 0..matrix.len() {
                if !rows[i][j] || !cols[i][j] {
                    return false;
                }
            }
        }
        true
    }
}