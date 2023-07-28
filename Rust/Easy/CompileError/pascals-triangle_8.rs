impl Solution {
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        
        let mut v = Vec::new();
        for i in 0..num_rows {
            let mut row = Vec::new();
            for j in 0..=i {
                if j == 0 || j == i {
                    row.push(1);
                } else {
                    row.push(v[(i - 1) as usize][(j - 1) as usize] + v[(i - 1) as usize][j as usize]);
                }
            }
            v.push(row);
        }
        v
    }
}