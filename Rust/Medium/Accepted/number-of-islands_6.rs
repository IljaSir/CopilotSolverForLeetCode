impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        

        let mut grid = grid;
        let mut count = 0;
        let mut stack = vec![];
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == '1' {
                    count += 1;
                    stack.push((i, j));
                    while !stack.is_empty() {
                        let (x, y) = stack.pop().unwrap();
                        if grid[x][y] == '1' {
                            grid[x][y] = '0';
                            if x > 0 {
                                stack.push((x - 1, y));
                            }
                            if x < grid.len() - 1 {
                                stack.push((x + 1, y));
                            }
                            if y > 0 {
                                stack.push((x, y - 1));
                            }
                            if y < grid[i].len() - 1 {
                                stack.push((x, y + 1));
                            }
                        }
                    }
                }
            }
        }
        count
    }
}