impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut stack = vec![(0, 0, 0)];
        while let Some((x, y, d)) = stack.pop() {
            if x == m - 1 && y == n - 1 {
                return true;
            }
            if visited[x][y] {
                continue;
            }
            visited[x][y] = true;
            let dirs = match grid[x][y] {
                '(' => vec![(0, 1), (1, 0)],
                ')' => vec![(0, -1), (-1, 0)],
                '/' => vec![(0, d), (d, 0)],
                '\\' => vec![(-d, 0), (0, -d)],
                _ => vec![(0, 1), (1, 0), (0, -1), (-1, 0)],
            };
            for (dx, dy) in dirs {
                let nx = x as i32 + dx;
                let ny = y as i32 + dy;
                if nx < 0 || ny < 0 || nx >= m as i32 || ny >= n as i32 {
                    continue;
                }
                let nx = nx as usize;
                let ny = ny as usize;
                if visited[nx][ny] {
                    continue;
                }
                match grid[nx][ny] {
                    '(' => {
                        if dy == 1 {
                            stack.push((nx, ny, 1));
                        }
                    }
                    ')' => {
                        if dy == -1 {
                            stack.push((nx, ny, -1));
                        }
                    }
                    '/' => {
                        if dx == 1 {
                            stack.push((nx, ny, 1));
                        } else {
                            stack.push((nx, ny, -1));
                        }
                    }
                    '\\' => {
                        if dx == 1 {
                            stack.push((nx, ny, -1));
                        } else {
                            stack.push((nx, ny, 1));
                        }
                    }
                    _ => {
                        stack.push((nx, ny, 0));
                    }
                }
            }
        }
        false
    }
}