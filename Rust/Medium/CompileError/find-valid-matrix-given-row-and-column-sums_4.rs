impl Solution {
    pub fn restore_matrix(row_sum: Vec<i32>, col_sum: Vec<i32>) -> Vec<Vec<i32>> {
        
        let mut matrix: Vec<Vec<i32>> = Vec::with_capacity(row_sum.len());
        let mut col_sum = col_sum;
        for row in row_sum {
            let mut row_vec: Vec<i32> = Vec::with_capacity(col_sum.len());
            for (i, col) in col_sum.iter().enumerate() {
                let min = std::cmp::min(row, *col);
                row_vec.push(min);
                col_sum[i] -= min;
            }
            matrix.push(row_vec);
        }
        matrix
    }
}