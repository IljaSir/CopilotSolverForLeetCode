impl Solution {
    pub fn max_area_of_island(grid: Vec<Vec<i32>>) -> i32 {
        

        let mut max_area = 0;
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                if grid[i][j] == 1 && !visited[i][j] {
                    let mut area = 0;
                    let mut stack = vec![(i, j)];
                    while !stack.is_empty() {
                        let (i, j) = stack.pop().unwrap();
                        if grid[i][j] == 1 && !visited[i][j] {
                            area += 1;
                            visited[i][j] = true;
                            if i > 0 {
                                stack.push((i - 1, j));
                            }
                            if i < grid.len() - 1 {
                                stack.push((i + 1, j));
                            }
                            if j > 0 {
                                stack.push((i, j - 1));
                            }
                            if j < grid[i].len() - 1 {
                                stack.push((i, j + 1));
                            }
                        }
                    }
                    if area > max_area {
                        max_area = area;
                    }
                }
            }
        }
        max_area
    }
}