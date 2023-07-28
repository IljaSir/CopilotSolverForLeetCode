impl Solution {
    pub fn count_servers(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let m = grid.len();
        let n = grid[0].len();
        let mut row = vec![0; m];
        let mut col = vec![0; n];
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    row[i] += 1;
                    col[j] += 1;
                }
            }
        }
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 && (row[i] > 1 || col[j] > 1) {
                    count += 1;
                }
            }
        }
        count
    }
}