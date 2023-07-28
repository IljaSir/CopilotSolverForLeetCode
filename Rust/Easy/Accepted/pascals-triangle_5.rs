impl Solution {
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        
        let mut rows: Vec<Vec<i32>> = Vec::new();
        for i in 0..num_rows as usize {
            let mut row: Vec<i32> = Vec::new();
            for j in 0..i + 1 {
                if j == 0 || j == i {
                    row.push(1);
                } else {
                    row.push(rows[i - 1][j - 1] + rows[i - 1][j]);
                }
            }
            rows.push(row);
        }
        rows
    }
}