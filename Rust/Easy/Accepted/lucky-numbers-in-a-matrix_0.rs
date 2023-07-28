impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut min_row = vec![std::i32::MAX; matrix.len()];
        let mut max_col = vec![std::i32::MIN; matrix[0].len()];
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                min_row[i] = std::cmp::min(min_row[i], matrix[i][j]);
                max_col[j] = std::cmp::max(max_col[j], matrix[i][j]);
            }
        }
        let mut res = vec![];
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                if matrix[i][j] == min_row[i] && matrix[i][j] == max_col[j] {
                    res.push(matrix[i][j]);
                }
            }
        }
        res
    }
}