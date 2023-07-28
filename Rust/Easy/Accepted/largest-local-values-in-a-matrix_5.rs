impl Solution {
    pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut max = vec![vec![0; grid.len() - 2]; grid.len() - 2];
        for i in 0..grid.len() - 2 {
            for j in 0..grid.len() - 2 {
                let mut max_val = 0;
                for k in 0..3 {
                    for l in 0..3 {
                        if grid[i + k][j + l] > max_val {
                            max_val = grid[i + k][j + l];
                        }
                    }
                }
                max[i][j] = max_val;
            }
        }
        max
    }
}