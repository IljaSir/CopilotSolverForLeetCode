impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ret: Vec<i32> = Vec::new();
        let mut row_min: Vec<i32> = Vec::new();
        let mut col_max: Vec<i32> = Vec::new();
        for row in &matrix {
            row_min.push(row.iter().min().unwrap().to_owned());
        }
        for col in 0..matrix[0].len() {
            let mut max = matrix[0][col];
            for row in 1..matrix.len() {
                if matrix[row][col] > max {
                    max = matrix[row][col];
                }
            }
            col_max.push(max);
        }
        for i in 0..row_min.len() {
            if col_max.contains(&row_min[i]) {
                ret.push(row_min[i]);
            }
        }
        ret
    }
}