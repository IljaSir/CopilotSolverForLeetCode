impl Solution {
    pub fn spiral_order(matrix: Vec<Vec<i32>>) -> Vec<i32> {
        

        let mut res: Vec<i32> = Vec::new();
        let mut min_row = 0;
        let mut max_row = matrix.len() - 1;
        let mut min_col = 0;
        let mut max_col = matrix[0].len() - 1;
        loop {
            for col in min_col..=max_col {
                res.push(matrix[min_row][col]);
            }
            min_row += 1;
            if min_row > max_row {
                break;
            }
            for row in min_row..=max_row {
                res.push(matrix[row][max_col]);
            }
            max_col -= 1;
            if min_col > max_col {
                break;
            }
            for col in (min_col..=max_col).rev() {
                res.push(matrix[max_row][col]);
            }
            max_row -= 1;
            if min_row > max_row {
                break;
            }
            for row in (min_row..=max_row).rev() {
                res.push(matrix[row][min_col]);
            }
            min_col += 1;
            if min_col > max_col {
                break;
            }
        }
        res
    }
}