impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut result: Vec<i32> = Vec::new();
        for i in 0..matrix.len() {
            let mut min = i32::MAX;
            let mut min_index = 0;
            for j in 0..matrix[i].len() {
                if matrix[i][j] < min {
                    min = matrix[i][j];
                    min_index = j;
                }
            }
            let mut max = i32::MIN;
            for k in 0..matrix.len() {
                if matrix[k][min_index] > max {
                    max = matrix[k][min_index];
                }
            }
            if max == min {
                result.push(max);
            }
        }
        result
    }
}