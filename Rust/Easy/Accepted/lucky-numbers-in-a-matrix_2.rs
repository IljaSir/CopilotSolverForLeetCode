impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        for i in 0..matrix.len() {
            let mut min = matrix[i][0];
            let mut min_idx = 0;
            for j in 1..matrix[i].len() {
                if matrix[i][j] < min {
                    min = matrix[i][j];
                    min_idx = j;
                }
            }
            let mut max = matrix[0][min_idx];
            for k in 0..matrix.len() {
                if matrix[k][min_idx] > max {
                    max = matrix[k][min_idx];
                }
            }
            if max == min {
                res.push(max);
            }
        }
        res
    }
}