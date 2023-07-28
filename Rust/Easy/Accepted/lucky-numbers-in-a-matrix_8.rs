impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut min = Vec::new();
        for i in 0..matrix.len() {
            let mut min_index = 0;
            for j in 1..matrix[i].len() {
                if matrix[i][j] < matrix[i][min_index] {
                    min_index = j;
                }
            }
            min.push((i, min_index));
        }
        let mut result = Vec::new();
        for (i, j) in min {
            let mut max = matrix[i][j];
            for k in 0..matrix.len() {
                if matrix[k][j] > max {
                    max = matrix[k][j];
                }
            }
            if max == matrix[i][j] {
                result.push(max);
            }
        }
        result
    }
}