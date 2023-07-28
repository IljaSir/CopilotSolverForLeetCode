impl Solution {
    pub fn oranges_rotting(grid: Vec<Vec<i32>>) -> i32 {
        
        let (mut queue, mut fresh, mut time) = (Vec::new(), 0, 0);
        for (i, row) in grid.iter().enumerate() {
            for (j, &cell) in row.iter().enumerate() {
                if cell == 2 {
                    queue.push((i, j));
                } else if cell == 1 {
                    fresh += 1;
                }
            }
        }
        let (mut x, mut y) = (0, 0);
        while !queue.is_empty() {
            let (i, j) = queue.remove(0);
            for (di, dj) in &[(0, 1), (0, -1), (1, 0), (-1, 0)] {
                x = i.wrapping_add(*di);
                y = j.wrapping_add(*dj);
                if x < grid.len() && y < grid[i].len() && grid[x][y] == 1 {
                    grid[x][y] = 2;
                    fresh -= 1;
                    queue.push((x, y));
                }
            }
            if queue.is_empty() && fresh > 0 {
                time += 1;
                for (i, row) in grid.iter().enumerate() {
                    for (j, &cell) in row.iter().enumerate() {
                        if cell == 2 {
                            queue.push((i, j));
                        }
                    }
                }
            }
        }
        if fresh > 0 { -1 } else { time }
    }
}