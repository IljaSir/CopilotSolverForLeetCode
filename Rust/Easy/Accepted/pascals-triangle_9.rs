impl Solution {
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        
        let mut rows = vec![vec![1]];
        for i in 1..num_rows {
            let mut row = vec![1];
            for j in 0..i-1 {
                row.push(rows[i as usize - 1][j as usize] + rows[i as usize - 1][(j+1) as usize]);
            }
            row.push(1);
            rows.push(row);
        }
        rows
    }
}