impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<i32>>) -> bool {
        
        let m = grid.len();
        let n = grid[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut queue = Vec::new();
        queue.push((0, 0));
        while !queue.is_empty() {
            let (x, y) = queue.remove(0);
            if x == m - 1 && y == n - 1 {
                return true;
            }
            visited[x][y] = true;
            let mut next = Vec::new();
            match grid[x][y] {
                1 => {
                    next.push((x, y - 1));
                    next.push((x, y + 1));
                },
                2 => {
                    next.push((x - 1, y));
                    next.push((x + 1, y));
                },
                3 => {
                    next.push((x, y - 1));
                    next.push((x + 1, y));
                },
                4 => {
                    next.push((x, y + 1));
                    next.push((x + 1, y));
                },
                5 => {
                    next.push((x, y - 1));
                    next.push((x - 1, y));
                },
                6 => {
                    next.push((x, y + 1));
                    next.push((x - 1, y));
                },
                _ => unreachable!(),
            }
            for (nx, ny) in next {
                if nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny] {
                    continue;
                }
                let mut ok = false;
                match grid[nx][ny] {
                    1 => {
                        if ny == y - 1 {
                            ok = true;
                        }
                        if ny == y + 1 {
                            ok = true;
                        }
                    },
                    2 => {
                        if nx == x - 1 {
                            ok = true;
                        }
                        if nx == x + 1 {
                            ok = true;
                        }
                    },
                    3 => {
                        if ny == y - 1 {
                            ok = true;
                        }
                        if nx == x + 1 {
                            ok = true;
                        }
                    },
                    4 => {
                        if ny == y + 1 {
                            ok = true;
                        }
                        if
    }
}