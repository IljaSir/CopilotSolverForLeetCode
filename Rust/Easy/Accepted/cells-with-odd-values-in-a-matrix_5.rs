impl Solution {
    pub fn odd_cells(m: i32, n: i32, indices: Vec<Vec<i32>>) -> i32 {
        
        let mut matrix = vec![vec![0; n as usize]; m as usize];
        for index in indices {
            let (r, c) = (index[0] as usize, index[1] as usize);
            for i in 0..n as usize {
                matrix[r][i] += 1;
            }
            for i in 0..m as usize {
                matrix[i][c] += 1;
            }
        }
        let mut count = 0;
        for row in matrix {
            for cell in row {
                if cell % 2 == 1 {
                    count += 1;
                }
            }
        }
        count
    }
}