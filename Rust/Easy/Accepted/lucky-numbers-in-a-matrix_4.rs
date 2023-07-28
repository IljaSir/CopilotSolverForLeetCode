impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result = Vec::new();
        for row in 0..matrix.len() {
            let mut min = matrix[row][0];
            let mut min_index = 0;
            for col in 1..matrix[row].len() {
                if matrix[row][col] < min {
                    min = matrix[row][col];
                    min_index = col;
                }
            }
            let mut max = matrix[0][min_index];
            for row2 in 1..matrix.len() {
                if matrix[row2][min_index] > max {
                    max = matrix[row2][min_index];
                }
            }
            if max == min {
                result.push(max);
            }
        }
        result
    }
}