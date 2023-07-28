impl Solution {
    pub fn check_valid(matrix: Vec<Vec<i32>>) -> bool {
        
        let n = matrix.len();
        let mut rows = vec![vec![false; n]; n];
        let mut cols = vec![vec![false; n]; n];
        for i in 0..n {
            for j in 0..n {
                let v = matrix[i][j] as usize - 1;
                if rows[i][v] || cols[j][v] {
                    return false;
                }
                rows[i][v] = true;
                cols[j][v] = true;
            }
        }
        true
    }
}