impl Solution {
    pub fn oranges_rotting(grid: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = grid;
        let mut fresh = 0;
        let mut rotting = Vec::new();
        for i in 0..grid.len() {
            for j in 0..grid[i].len() {
                match grid[i][j] {
                    1 => fresh += 1,
                    2 => rotting.push((i, j)),
                    _ => (),
                }
            }
        }
        let mut minutes = 0;
        while fresh > 0 {
            let mut new_rotting = Vec::new();
            for (i, j) in rotting {
                if i > 0 && grid[i-1][j] == 1 {
                    grid[i-1][j] = 2;
                    fresh -= 1;
                    new_rotting.push((i-1, j));
                }
                if i < grid.len()-1 && grid[i+1][j] == 1 {
                    grid[i+1][j] = 2;
                    fresh -= 1;
                    new_rotting.push((i+1, j));
                }
                if j > 0 && grid[i][j-1] == 1 {
                    grid[i][j-1] = 2;
                    fresh -= 1;
                    new_rotting.push((i, j-1));
                }
                if j < grid[i].len()-1 && grid[i][j+1] == 1 {
                    grid[i][j+1] = 2;
                    fresh -= 1;
                    new_rotting.push((i, j+1));
                }
            }
            if new_rotting.len() == 0 {
                return -1;
            }
            minutes += 1;
            rotting = new_rotting;
        }
        minutes
    }
}