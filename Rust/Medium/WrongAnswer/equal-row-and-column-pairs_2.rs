impl Solution {
    pub fn equal_pairs(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let n = grid.len();
        for i in 0..n {
            for j in 0..n {
                if grid[i][j] == grid[j][i] {
                    count += 1;
                }
            }
        }
        count
    }
}