impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        

        let mut grid = grid;
        let mut max = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 {
                    let mut area = 0;
                    let mut stack = vec![(i, j)];
                    while let Some((x, y)) = stack.pop() {
                        if x >= grid.len() || y >= grid[x].len() || grid[x][y] == 0 {
                            continue;
                        }
                        area += 1;
                        grid[x][y] = 0;
                        stack.push((x + 1, y));
                        stack.push((x, y + 1));
                        stack.push((x, y.wrapping_sub(1)));
                        stack.push((x.wrapping_sub(1), y));
                    }
                    max = max.max(area);
                }
            }
        }
        max
    }
}