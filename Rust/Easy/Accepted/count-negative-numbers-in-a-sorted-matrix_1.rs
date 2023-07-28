impl Solution {
    pub fn count_negatives(grid: Vec<Vec<i32>>) -> i32 {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut count = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] < 0 {
                    count += 1;
                }
            }
        }
        return count;
    }
}