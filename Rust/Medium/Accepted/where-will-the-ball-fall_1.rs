impl Solution {
    pub fn find_ball(grid: Vec<Vec<i32>>) -> Vec<i32> {
        
        let mut res = vec![];
        for i in 0..grid[0].len() {
            let mut col = i as i32;
            let mut row = 0;
            while row < grid.len() {
                if grid[row][col as usize] == 1 {
                    if col == grid[0].len() as i32 - 1 || grid[row][col as usize + 1] == -1 {
                        col = -1;
                        break;
                    }
                    col += 1;
                } else {
                    if col == 0 || grid[row][col as usize - 1] == 1 {
                        col = -1;
                        break;
                    }
                    col -= 1;
                }
                row += 1;
            }
            res.push(col);
        }
        res
    }
}