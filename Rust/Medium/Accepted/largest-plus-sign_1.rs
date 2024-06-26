impl Solution {
    pub fn order_of_largest_plus_sign(n: i32, mines: Vec<Vec<i32>>) -> i32 {
        
        let mut grid = vec![vec![1; n as usize]; n as usize];
        for mine in mines {
            grid[mine[0] as usize][mine[1] as usize] = 0;
        }
        let mut left = vec![vec![0; n as usize]; n as usize];
        let mut right = vec![vec![0; n as usize]; n as usize];
        let mut up = vec![vec![0; n as usize]; n as usize];
        let mut down = vec![vec![0; n as usize]; n as usize];
        for i in 0..n {
            for j in 0..n {
                if grid[i as usize][j as usize] == 1 {
                    left[i as usize][j as usize] = if j == 0 { 1 } else { left[i as usize][(j - 1) as usize] + 1 };
                    up[i as usize][j as usize] = if i == 0 { 1 } else { up[(i - 1) as usize][j as usize] + 1 };
                }
            }
        }
        for i in (0..n).rev() {
            for j in (0..n).rev() {
                if grid[i as usize][j as usize] == 1 {
                    right[i as usize][j as usize] = if j == n - 1 { 1 } else { right[i as usize][(j + 1) as usize] + 1 };
                    down[i as usize][j as usize] = if i == n - 1 { 1 } else { down[(i + 1) as usize][j as usize] + 1 };
                }
            }
        }
        let mut max = 0;
        for i in 0..n {
            for j in 0..n {
                let cur = std::cmp::min(left[i as usize][j as usize], std::cmp::min(right[i as usize][j as usize], std::cmp::min(down[i as usize][j as usize], up[i as usize][j as usize])));
                max = std::cmp::max(max, cur);
            }
        }
        max
    }
}