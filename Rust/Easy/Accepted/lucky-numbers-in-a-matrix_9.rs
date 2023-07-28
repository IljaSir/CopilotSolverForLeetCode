impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut ret = Vec::new();
        for i in 0..matrix.len() {
            let mut min = 100000;
            let mut min_idx = 0;
            for j in 0..matrix[i].len() {
                if matrix[i][j] < min {
                    min = matrix[i][j];
                    min_idx = j;
                }
            }
            let mut max = 0;
            for j in 0..matrix.len() {
                if matrix[j][min_idx] > max {
                    max = matrix[j][min_idx];
                }
            }
            if min == max {
                ret.push(min);
            }
        }
        ret
    }
}