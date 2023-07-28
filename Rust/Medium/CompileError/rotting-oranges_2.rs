impl Solution {
    pub fn oranges_rotting(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut rotten = vec![];
        let mut fresh = 0;
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                match grid[i][j] {
                    2 => rotten.push((i, j)),
                    1 => fresh += 1,
                    _ => (),
                }
            }
        }
        let mut time = 0;
        let mut next = vec![];
        while rotten.len() > 0 {
            for &(i, j) in rotten.iter() {
                if i > 0 && grid[i - 1][j] == 1 {
                    fresh -= 1;
                    grid[i - 1][j] = 2;
                    next.push((i - 1, j));
                }
                if i < grid.len() - 1 && grid[i + 1][j] == 1 {
                    fresh -= 1;
                    grid[i + 1][j] = 2;
                    next.push((i + 1, j));
                }
                if j > 0 && grid[i][j - 1] == 1 {
                    fresh -= 1;
                    grid[i][j - 1] = 2;
                    next.push((i, j - 1));
                }
                if j < grid[i].len() - 1 && grid[i][j + 1] == 1 {
                    fresh -= 1;
                    grid[i][j + 1] = 2;
                    next.push((i, j + 1));
                }
            }
            if next.len() > 0 {
                time += 1;
                rotten = next;
                next = vec![];
            } else {
                break;
            }
        }
        if fresh > 0 {
            -1
        } else {
            time
        }
    }
}