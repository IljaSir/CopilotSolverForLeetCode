impl Solution {
    pub fn restore_matrix(row_sum: Vec<i32>, col_sum: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut res = vec![vec![0; col_sum.len()]; row_sum.len()];
        for i in 0..row_sum.len() {
            for j in 0..col_sum.len() {
                res[i][j] = std::cmp::min(row_sum[i], col_sum[j]);
                if res[i][j] == row_sum[i] {
                    break;
                }
            }
        }
        for i in 0..row_sum.len() {
            for j in 0..col_sum.len() {
                if res[i][j] == col_sum[j] {
                    break;
                }
            }
        }
        res
    }
}