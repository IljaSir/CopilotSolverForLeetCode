impl Solution {
    pub fn equal_pairs(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut row = vec![vec![]; grid.len()];
        let mut col = vec![vec![]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                row[i].push(grid[i][j]);
                col[j].push(grid[i][j]);
            }
        }
        for i in 0..grid.len() {
            for j in 0..grid.len() {
                if row[i] == col[j] {
                    count += 1;
                }
            }
        }
        count
    }
}