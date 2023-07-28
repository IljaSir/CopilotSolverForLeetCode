impl Solution {
    pub fn equal_pairs(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == grid[j][i] {
                    count += 1;
                }
            }
        }
        count
    }
}