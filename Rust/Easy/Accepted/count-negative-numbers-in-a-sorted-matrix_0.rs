impl Solution {
    pub fn count_negatives(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] < 0 {
                    count += 1;
                }
            }
        }
        count
    }
}