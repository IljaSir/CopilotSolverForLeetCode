impl Solution {
    pub fn lucky_numbers (matrix: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut min = vec![i32::MAX; matrix[0].len()];
        let mut max = vec![i32::MIN; matrix.len()];
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                min[j] = min[j].min(matrix[i][j]);
                max[i] = max[i].max(matrix[i][j]);
            }
        }
        let mut ans = vec![];
        for i in 0..matrix.len() {
            for j in 0..matrix[0].len() {
                if min[j] == max[i] {
                    ans.push(min[j]);
                }
            }
        }
        ans
    }
}