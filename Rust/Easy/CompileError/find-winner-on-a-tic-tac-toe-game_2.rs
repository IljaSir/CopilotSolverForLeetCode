impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        
        let mut grid = [[' '; 3]; 3];
        for (i, mv) in moves.iter().enumerate() {
            if i % 2 == 0 {
                grid[mv[0] as usize][mv[1] as usize] = 'X';
            } else {
                grid[mv[0] as usize][mv[1] as usize] = 'O';
            }
        }
        if grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][0] != ' ' {
            return grid[0][0].to_string();
        }
        if grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][0] != ' ' {
            return grid[1][0].to_string();
        }
        if grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][0] != ' ' {
            return grid[2][0].to_string();
        }
        if grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0] && grid[0][0] != ' ' {
            return grid[0][0].to_string();
        }
        if grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1] && grid[0][1] != ' ' {
            return grid[0][1].to_string();
        }
        if grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2] && grid[0][2] != ' ' {
            return grid[0][2].to_string();
        }
        if grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != ' ' {
            return grid[0][0].to_string();
        }
        if grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != ' ' {
    }
}