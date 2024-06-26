impl Solution {
    pub fn diagonal_sum(mat: Vec<Vec<i32>>) -> i32 {
        
        let mut sum = 0;
        let n = mat.len();
        for i in 0..n {
            sum += mat[i][i];
            if i != n - i - 1 {
                sum += mat[i][n - i - 1];
            }
        }
        sum
    }
}