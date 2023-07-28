impl Solution {
    pub fn largest_local(grid: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let n = grid.len();
        let mut max_local = vec![vec![0; n - 2]; n - 2];
        for i in 0..n - 2 {
            for j in 0..n - 2 {
                max_local[i][j] = grid[i][j..j + 3].iter().max().unwrap();
                max_local[i][j] = max_local[i][j].max(grid[i + 1][j..j + 3].iter().max().unwrap());
                max_local[i][j] = max_local[i][j].max(grid[i + 2][j..j + 3].iter().max().unwrap());
            }
        }
        max_local
    }
}