impl Solution {
    pub fn generate(num_rows: i32) -> Vec<Vec<i32>> {
        
        let mut result: Vec<Vec<i32>> = Vec::new();
        for i in 0..num_rows {
            let mut row: Vec<i32> = Vec::new();
            for j in 0..=i {
                if j == 0 || j == i {
                    row.push(1);
                } else {
                    let left = result[(i - 1) as usize][(j - 1) as usize];
                    let right = result[(i - 1) as usize][j as usize];
                    row.push(left + right);
                }
            }
            result.push(row);
        }
        result
    }
}