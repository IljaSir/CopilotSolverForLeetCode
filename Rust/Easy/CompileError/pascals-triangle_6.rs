impl Solution {
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        
        let mut res = Vec::new();
        for i in 0..num_rows {
            let mut row = Vec::new();
            for j in 0..i+1 {
                if j == 0 || j == i {
                    row.push(1);
                } else {
                    let last_row = &res[(i-1) as usize];
                    row.push(last_row[(j-1) as usize] + last_row[j as usize]);
                }
            }
            res.push(row);
        }
        res
    }
}