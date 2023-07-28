impl Solution {
    pub fn set_zeroes(matrix: &mut Vec<Vec<i32>>) {
        

        let mut zero_rows = vec![];
        let mut zero_cols = vec![];
        for (i, row) in matrix.iter().enumerate() {
            for (j, &val) in row.iter().enumerate() {
                if val == 0 {
                    zero_rows.push(i);
                    zero_cols.push(j);
                }
            }
        }
        for i in zero_rows {
            for j in 0..matrix[i].len() {
                matrix[i][j] = 0;
            }
        }
        for j in zero_cols {
            for i in 0..matrix.len() {
                matrix[i][j] = 0;
            }
        }