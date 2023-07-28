impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        
        let mut q = std::collections::VecDeque::new();
        let mut visited = vec![vec![false; grid[0].len()]; grid.len()];
        q.push_back((0, 0, 0));
        while !q.is_empty() {
            let (x, y, cnt) = q.pop_front().unwrap();
            if visited[x][y] { continue; }
            visited[x][y] = true;
            if x == grid.len() - 1 && y == grid[0].len() - 1 { return true; }
            let c = grid[x][y];
            if c == '(' {
                if y + 1 < grid[0].len() && grid[x][y + 1] == ')' {
                    q.push_back((x, y + 1, cnt + 1));
                }
                if x + 1 < grid.len() && grid[x + 1][y] == ')' {
                    q.push_back((x + 1, y, cnt + 1));
                }
            } else if c == ')' {
                if y > 0 && grid[x][y - 1] == '(' {
                    q.push_back((x, y - 1, cnt + 1));
                }
                if x > 0 && grid[x - 1][y] == '(' {
                    q.push_back((x - 1, y, cnt + 1));
                }
            } else if c == '*' {
                if y + 1 < grid[0].len() && grid[x][y + 1] != '(' {
                    q.push_back((x, y + 1, cnt + 1));
                }
                if x + 1 < grid.len() && grid[x + 1][y] != '(' {
                    q.push_back((x + 1, y, cnt + 1));
                }
                if y > 0 && grid[x][y - 1] != ')' {
                    q.push_back((x, y - 1, cnt + 1));
                }
                if x > 0 && grid[x - 1][y] != ')' {
                    q.push_back((x - 1, y, cnt + 1));
                }
            } else if c == '|' {
                if y + 1 < grid[0].len() && grid[x][y + 1] !=
    }
}