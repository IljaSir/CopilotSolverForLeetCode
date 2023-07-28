impl Solution {
    pub fn equal_pairs(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut row = vec![0; grid.len()];
        let mut col = vec![0; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                if grid[i][j] == grid[j][i] {
                    count += 1;
                }
            }
        }
        count
    }
}