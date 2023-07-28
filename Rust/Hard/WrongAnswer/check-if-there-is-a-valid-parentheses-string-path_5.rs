impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        
        let mut queue = Vec::new();
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        queue.push((0, 0));
        while !queue.is_empty() {
            let (x, y) = queue.remove(0);
            if x == grid.len() - 1 && y == grid[0].len() - 1 {
                return true;
            }
            if visited[x][y] {
                continue;
            }
            visited[x][y] = true;
            match grid[x][y] {
                '(' => {
                    if y + 1 < grid[0].len() && grid[x][y + 1] == ')' {
                        queue.push((x, y + 1));
                    }
                }
                ')' => {
                    if y > 0 && grid[x][y - 1] == '(' {
                        queue.push((x, y - 1));
                    }
                }
                '[' => {
                    if x + 1 < grid.len() && grid[x + 1][y] == ']' {
                        queue.push((x + 1, y));
                    }
                }
                ']' => {
                    if x > 0 && grid[x - 1][y] == '[' {
                        queue.push((x - 1, y));
                    }
                }
                '{' => {
                    if x + 1 < grid.len() && grid[x + 1][y] == '}' {
                        queue.push((x + 1, y));
                    }
                }
                '}' => {
                    if x > 0 && grid[x - 1][y] == '{' {
                        queue.push((x - 1, y));
                    }
                }
                _ => {}
            }
        }
        false
    }
}