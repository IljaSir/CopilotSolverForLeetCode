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
                matrix[j as usize][(n - i - 1) as usize] = num;
                num += 1;
                j += 1;
            }
            j = (n - i - 2) as i32;
            while j > i {
                matrix[(n - i - 1) as usize][j as usize] = num;
                num += 1;
                j -= 1;
            }
            j = (n - i - 1) as i32;
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