impl Solution {
    pub fn largest_submatrix(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut matrix = matrix;
        let m = matrix.len();
        let n = matrix[0].len();
        let mut ans = 0;
        for i in 0..m {
            for j in 0..n {
                if i > 0 && matrix[i][j] == 1 {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            matrix[i].sort();
            for j in 0..n {
                ans = ans.max((n - j) as i32 * matrix[i][j]);
            }
        }
        ans
    }
}