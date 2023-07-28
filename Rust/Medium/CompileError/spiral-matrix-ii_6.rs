impl Solution {
    pub fn generate_matrix(n: i32) -> Vec<Vec<i32>> {
        

        let n = n as usize;
        let mut matrix = vec![vec![0; n]; n];
        let mut num = 1;
        let mut i = 0;
        while num <= n * n {
            let mut j = i;
            while j < n - i {
                matrix[i][j] = num;
                num += 1;
                j += 1;
            }
            j = i + 1;
            while j < n - i {
                matrix[j][n - i - 1] = num;
                num += 1;
                j += 1;
            }
            j = n - i - 2;
            while j > i {
                matrix[n - i - 1][j] = num;
                num += 1;
                j -= 1;
            }
            j = n - i - 1;
            while j > i {
                matrix[j][i] = num;
                num += 1;
                j -= 1;
            }
            i += 1;
        }
        matrix
    }
}