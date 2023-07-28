impl Solution {
    pub fn is_possible_to_cut_path(grid: Vec<Vec<i32>>) -> bool {
        
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        let mut path = vec![(0, 0)];
        let mut stack = vec![(0, 0)];
        let mut flip = false;
        while !stack.is_empty() {
            let (x, y) = stack.pop().unwrap();
            if x == grid.len() - 1 && y == grid[0].len() - 1 {
                return true;
            }
            visited[x][y] = true;
            let mut valid = false;
            if x < grid.len() - 1 && grid[x + 1][y] == 1 {
                if !visited[x + 1][y] {
                    stack.push((x + 1, y));
                    valid = true;
                }
            }
            if y < grid[0].len() - 1 && grid[x][y + 1] == 1 {
                if !visited[x][y + 1] {
                    stack.push((x, y + 1));
                    valid = true;
                }
            }
            if !valid {
                path.pop();
                if !path.is_empty() {
                    let (x, y) = path[path.len() - 1];
                    if !visited[x][y] {
                        stack.push((x, y));
                    }
                }
            } else {
                path.push((x, y));
            }
            if !flip {
                if x < grid.len() - 1 && grid[x + 1][y] == 0 {
                    grid[x + 1][y] = 1;
                    visited = vec![vec![false; grid[0].len()]; grid.len()];
                    path = vec![(0, 0)];
                    stack = vec![(0, 0)];
                    flip = true;
                }
                if y < grid[0].len() - 1 && grid[x][y + 1] == 0 {
                    grid[x][y + 1] = 1;
                    visited = vec![vec![false; grid[0].len()]; grid.len()];
                    path = vec![(0, 0)];
                    stack = vec![(0, 0)];
                    flip = true;
                }
            }
        }
        false
    }
}