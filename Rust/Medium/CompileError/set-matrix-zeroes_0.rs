impl Solution {
    pub fn set_zeroes(matrix: &mut Vec<Vec<i32>>) {
        

        let m = matrix.len();
        let n = matrix[0].len();
        let mut row = vec![0; m];
        let mut col = vec![0; n];
        for i in 0..m {
            for j in 0..n {
                if matrix[i][j] == 0 {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for i in 0..m {
            for j in 0..n {
                if row[i] == 1 || col[j] == 1 {
                    matrix[i][j] = 0;
                }
            }
        }