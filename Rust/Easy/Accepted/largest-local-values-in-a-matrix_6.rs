impl Solution {
    pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut result = Vec::new();
        let n = grid.len();
        for i in 0..n - 2 {
            let mut row = Vec::new();
            for j in 0..n - 2 {
                let mut max = 0;
                for k in i..i + 3 {
                    for l in j..j + 3 {
                        max = max.max(grid[k][l]);
                    }
                }
                row.push(max);
            }
            result.push(row);
        }
        result
    }
}