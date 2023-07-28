impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        let m = matrix.len();
        let n = matrix[0].len();
        let mut min_row = vec![std::i32::MAX; n];
        let mut max_col = vec![std::i32::MIN; m];
        for i in 0..m {
            for j in 0..n {
                min_row[j] = min_row[j].min(matrix[i][j]);
                max_col[i] = max_col[i].max(matrix[i][j]);
            }
        }
        for i in 0..m {
            for j in 0..n {
                if matrix[i][j] == min_row[j] && matrix[i][j] == max_col[i] {
                    res.push(matrix[i][j]);
                }
            }
        }
        res
    }
}