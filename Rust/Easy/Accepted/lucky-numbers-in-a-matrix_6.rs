impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let (mut min, mut max) = (vec![i32::max_value(); matrix.len()], vec![i32::min_value(); matrix[0].len()]);
        for i in 0..matrix.len() {
            for j in 0..matrix[i].len() {
                min[i] = min[i].min(matrix[i][j]);
                max[j] = max[j].max(matrix[i][j]);
            }
        }
        let mut res = vec![];
        for i in 0..matrix.len() {
            for j in 0..matrix[i].len() {
                if matrix[i][j] == min[i] && matrix[i][j] == max[j] {
                    res.push(matrix[i][j]);
                }
            }
        }
        res
    }
}