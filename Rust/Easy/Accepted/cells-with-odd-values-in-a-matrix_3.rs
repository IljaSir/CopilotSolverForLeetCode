impl Solution {
    pub fn odd_cells(m: i32, n: i32, indices: Vec<Vec<i32>>) -> i32 {
        
        let mut row = vec![0; m as usize];
        let mut col = vec![0; n as usize];
        for i in 0..indices.len() {
            row[indices[i][0] as usize] += 1;
            col[indices[i][1] as usize] += 1;
        }
        let mut odd = 0;
        for i in 0..m as usize {
            for j in 0..n as usize {
                if (row[i] + col[j]) % 2 == 1 {
                    odd += 1;
                }
            }
        }
        odd
    }
}