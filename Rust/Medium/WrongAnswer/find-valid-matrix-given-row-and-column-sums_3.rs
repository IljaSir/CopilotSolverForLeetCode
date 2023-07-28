impl Solution {
    pub fn restore_matrix(row_sum: Vec<i32>, col_sum: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut res = vec![vec![0; col_sum.len()]; row_sum.len()];
        for (i, r) in row_sum.iter().enumerate() {
            for (j, c) in col_sum.iter().enumerate() {
                res[i][j] = std::cmp::min(*r, *c);
            }
        }
        for (i, r) in row_sum.iter().enumerate() {
            for (j, c) in col_sum.iter().enumerate() {
                let diff = *r - res[i][j];
                if diff > 0 {
                    res[i][j] += diff;
                }
            }
        }
        res
    }
}