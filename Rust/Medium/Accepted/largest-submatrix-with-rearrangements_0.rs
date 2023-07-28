impl Solution {
    pub fn largest_submatrix(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut matrix = matrix;
        let m = matrix.len();
        let n = matrix[0].len();
        for i in 1..m {
            for j in 0..n {
                if matrix[i][j] == 1 {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        let mut ans = 0;
        for i in 0..m {
            matrix[i].sort();
            for j in 0..n {
                ans = ans.max(matrix[i][j] * (n - j) as i32);
            }
        }
        ans
    }
}