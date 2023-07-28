impl Solution {
    pub fn restore_matrix(row_sum: Vec<i32>, col_sum: Vec<i32>) -> Vec<Vec<i32>> {
        
        let r = row_sum.len();
        let c = col_sum.len();
        let mut ans = vec![vec![0; c]; r];
        for i in 0..r {
            for j in 0..c {
                ans[i][j] = row_sum[i].min(col_sum[j]);
                row_sum[i] -= ans[i][j];
                col_sum[j] -= ans[i][j];
            }
        }
        ans
    }
}