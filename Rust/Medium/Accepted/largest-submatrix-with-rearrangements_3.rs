impl Solution {
    pub fn largest_submatrix(matrix: Vec<Vec<i32>>) -> i32 {
        
        let mut matrix = matrix;
        let m = matrix.len();
        let n = matrix[0].len();
        
        for i in 1..m {
            for j in 0..n {
                if matrix[i][j] == 1 {
                    matrix[i][j] += matrix[i-1][j];
                }
            }
        }
        
        let mut result = 0;
        for i in 0..m {
            let mut row = matrix[i].clone();
            row.sort();
            for j in 0..n {
                result = result.max(row[j] * (n-j) as i32);
            }
        }
        result
    }
}