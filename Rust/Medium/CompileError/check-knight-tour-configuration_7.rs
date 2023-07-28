impl Solution {
    pub fn check_valid_grid(grid: Vec<Vec<i32>>) -> bool {
        
        let n = grid.len();
        let mut visited = vec![vec![false; n]; n];
        let mut row = 0;
        let mut col = 0;
        let mut prev = 0;
        for i in 0..n*n {
            let r = row;
            let c = col;
            if visited[r][c] {
                return false;
            }
            visited[r][c] = true;
            if grid[r][c] != i as i32 {
                return false;
            }
            let mut next = (prev + 1) % 8;
            let mut found = false;
            for _ in 0..8 {
                let mut nr = r as i32;
                let mut nc = c as i32;
                match next {
                    0 => {
                        nr -= 2;
                        nc -= 1;
                    },
                    1 => {
                        nr -= 2;
                        nc += 1;
                    },
                    2 => {
                        nr -= 1;
                        nc -= 2;
                    },
                    3 => {
                        nr -= 1;
                        nc += 2;
                    },
                    4 => {
                        nr += 1;
                        nc -= 2;
                    },
                    5 => {
                        nr += 1;
                        nc += 2;
                    },
                    6 => {
                        nr += 2;
                        nc -= 1;
                    },
                    7 => {
                        nr += 2;
                        nc += 1;
                    },
                    _ => {}
                }
                if nr >= 0 && nc >= 0 && nr < n as i32 && nc < n as i32 {
                    found = true;
                    break;
                }
                next = (next + 1) % 8;
            }
            if !found {
                return false;
            }
            prev = next;
            row = nr as usize;
            col = nc as usize;
        }
        true
    }
}