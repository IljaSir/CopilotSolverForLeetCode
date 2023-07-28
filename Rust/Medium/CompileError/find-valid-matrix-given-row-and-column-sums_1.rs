impl Solution {
    pub fn restore_matrix(row_sum: Vec<i32>, col_sum: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut res: Vec<Vec<i32>> = vec![vec![0; col_sum.len()]; row_sum.len()];
        for i in 0..row_sum.len() {
            for j in 0..col_sum.len() {
                res[i][j] = row_sum[i].min(col_sum[j]);
                row_sum[i] -= res[i][j];
                col_sum[j] -= res[i][j];
            }
        }
        res
    }
}