impl Solution {
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        for i in 0..num_rows {
            let mut row = Vec::new();
            for j in 0..=i {
                if j == 0 || j == i {
                    row.push(1);
                } else {
                    row.push(result[i as usize - 1][j as usize - 1] + result[i as usize - 1][j as usize]);
                }
            }
            result.push(row);
        }
        result
    }
}