impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut result = Vec::new();
        
        let mut row_start = 0;
        let mut row_end = matrix.len() - 1;
        let mut col_start = 0;
        let mut col_end = matrix[0].len() - 1;
        
        while row_start <= row_end && col_start <= col_end {
            for i in col_start..=col_end {
                result.push(matrix[row_start][i]);
            }
            row_start += 1;
            for i in row_start..=row_end {
                result.push(matrix[i][col_end]);
            }
            col_end -= 1;
            if row_start <= row_end {
                for i in (col_start..=col_end).rev() {
                    result.push(matrix[row_end][i]);
                }
                row_end -= 1;
            }
            if col_start <= col_end {
                for i in (row_start..=row_end).rev() {
                    result.push(matrix[i][col_start]);
                }
                col_start += 1;
            }
        }
        
        result
    }
}