impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        
        let mut board = vec![vec![' '; 3]; 3];
        let mut i = 0;
        for move_ in moves {
            if i % 2 == 0 {
                board[move_[0] as usize][move_[1] as usize] = 'X';
            } else {
                board[move_[0] as usize][move_[1] as usize] = 'O';
            }
            i += 1;
        }
        if i < 5 {
            return "Pending".to_string();
        }
        if board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ' {
            return board[0][0].to_string();
        }
        if board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ' {
            return board[0][2].to_string();
        }
        for i in 0..3 {
            if board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ' {
                return board[i][0].to_string();
            }
            if board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ' {
                return board[0][i].to_string();
            }
        }
        if i == 9 {
            return "Draw".to_string();
        }
        "Pending".to_string()
    }
}