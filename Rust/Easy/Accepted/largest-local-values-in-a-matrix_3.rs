impl Solution {
    pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let n = grid.len();
        let mut max_local = vec![vec![0; n - 2]; n - 2];
        for i in 1..(n - 1) {
            for j in 1..(n - 1) {
                max_local[i - 1][j - 1] = vec![
                    grid[i - 1][j - 1],
                    grid[i - 1][j],
                    grid[i - 1][j + 1],
                    grid[i][j - 1],
                    grid[i][j],
                    grid[i][j + 1],
                    grid[i + 1][j - 1],
                    grid[i + 1][j],
                    grid[i + 1][j + 1],
                ].iter().max().unwrap().clone();
            }
        }
        max_local
    }
}