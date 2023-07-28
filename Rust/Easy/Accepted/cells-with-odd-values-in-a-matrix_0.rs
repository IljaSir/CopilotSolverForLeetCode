impl Solution {
    pub fn odd_cells(m: i32, n: i32, indices: Vec<Vec<i32>>) -> i32 {
        
        let mut rows = vec![0; m as usize];
        let mut cols = vec![0; n as usize];
        for index in indices {
            rows[index[0] as usize] += 1;
            cols[index[1] as usize] += 1;
        }
        let mut odd = 0;
        for row in rows {
            for col in &cols {
                if (row + col) % 2 == 1 {
                    odd += 1;
                }
            }
        }
        odd
    }
}