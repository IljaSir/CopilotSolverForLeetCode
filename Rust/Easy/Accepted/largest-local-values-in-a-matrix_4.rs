impl Solution {
    pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut maxLocal = vec![vec![0; grid.len() - 2]; grid.len() - 2];
        for i in 0..grid.len() - 2 {
            for j in 0..grid.len() - 2 {
                let mut max = grid[i][j];
                for k in 0..3 {
                    for l in 0..3 {
                        max = max.max(grid[i + k][j + l]);
                    }
                }
                maxLocal[i][j] = max;
            }
        }
        maxLocal
    }
}