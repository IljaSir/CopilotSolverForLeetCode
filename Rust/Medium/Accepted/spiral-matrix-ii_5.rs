impl Solution {
    pub fn generate_matrix(n: i32) -> Vec<Vec<i32>> {
        

        let mut matrix = vec![vec![0; n as usize]; n as usize];
        let mut num = 1;
        let mut i = 0;
        while num <= n * n {
            let mut j = i;
            while j < n - i {
                matrix[i as usize][j as usize] = num;
                num += 1;
                j += 1;
            }
            j = i + 1;
            while j < n - i {
                matrix[j as usize][(n - 1 - i) as usize] = num;
                num += 1;
                j += 1;
            }
            j = n - 2 - i;
            while j > i {
                matrix[(n - 1 - i) as usize][j as usize] = num;
                num += 1;
                j -= 1;
            }
            j = n - 1 - i;
            while j > i {
                matrix[j as usize][i as usize] = num;
                num += 1;
                j -= 1;
            }
            i += 1;
        }
        matrix
    }
}