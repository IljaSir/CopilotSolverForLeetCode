impl Solution {
    pub fn odd_cells(m: i32, n: i32, indices: Vec<Vec<i32>>) -> i32 {
        
        let mut rows = vec![0; m as usize];
        let mut cols = vec![0; n as usize];
        for i in indices {
            rows[i[0] as usize] += 1;
            cols[i[1] as usize] += 1;
        }
        let mut result = 0;
        for i in 0..m {
            for j in 0..n {
                if (rows[i as usize] + cols[j as usize]) % 2 != 0 {
                    result += 1;
                }
            }
        }
        result
    }
}