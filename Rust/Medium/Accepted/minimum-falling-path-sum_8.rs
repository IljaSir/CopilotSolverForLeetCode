impl Solution {
    pub fn min_falling_path_sum(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut f = vec![vec![0; matrix.len()]; matrix.len()];
        for i in 0..matrix.len() {
            f[0][i] = matrix[0][i];
        }
        for i in 1..matrix.len() {
            for j in 0..matrix.len() {
                f[i][j] = matrix[i][j] + f[i-1][j];
                if j > 0 {
                    f[i][j] = f[i][j].min(matrix[i][j] + f[i-1][j-1]);
                }
                if j < matrix.len() - 1 {
                    f[i][j] = f[i][j].min(matrix[i][j] + f[i-1][j+1]);
                }
            }
        }
        f[matrix.len()-1].iter().min().unwrap().to_owned()
    }
}