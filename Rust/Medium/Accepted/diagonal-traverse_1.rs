impl Solution {
    pub fn find_diagonal_order(mat: Vec<Vec<i32>>) -> Vec<i32> {
        

        let m = mat.len();
        let n = mat[0].len();
        let mut result = vec![0; m * n];
        let mut i = 0;
        let mut j = 0;
        for k in 0..m * n {
            result[k] = mat[i][j];
            if (i + j) % 2 == 0 {
                if j == n - 1 {
                    i += 1;
                } else if i == 0 {
                    j += 1;
                } else {
                    i -= 1;
                    j += 1;
                }
            } else {
                if i == m - 1 {
                    j += 1;
                } else if j == 0 {
                    i += 1;
                } else {
                    i += 1;
                    j -= 1;
                }
            }
        }
        result
    }
}