impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        
        let mut grid = vec![vec![' '; 3]; 3];
        for (i, m) in moves.iter().enumerate() {
            let (r, c) = (m[0] as usize, m[1] as usize);
            grid[r][c] = if i % 2 == 0 { 'X' } else { 'O' };
        }
        let mut ans = "Pending";
        for i in 0..3 {
            if grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != ' ' {
                ans = if grid[i][0] == 'X' { "A" } else { "B" };
            }
            if grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != ' ' {
                ans = if grid[0][i] == 'X' { "A" } else { "B" };
            }
        }
        if grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ' {
            ans = if grid[0][0] == 'X' { "A" } else { "B" };
        }
        if grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' ' {
            ans = if grid[0][2] == 'X' { "A" } else { "B" };
        }
        if ans == "Pending" && moves.len() == 9 {
            ans = "Draw";
        }
        ans.to_string()
    }
}