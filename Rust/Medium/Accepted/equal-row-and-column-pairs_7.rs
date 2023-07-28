impl Solution {
    pub fn equal_pairs(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut count = 0;
        let mut row = vec![];
        let mut col = vec![];
        for i in 0..grid.len() {
            row.push(grid[i].to_vec());
            col.push(vec![]);
            for j in 0..grid[i].len() {
                col[i].push(grid[j][i]);
            }
        }
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if row[i] == col[j] {
                    count += 1;
                }
            }
        }
        count
    }
}