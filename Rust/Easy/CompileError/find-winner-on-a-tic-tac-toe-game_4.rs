impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        
        let mut board = vec![vec![' '; 3]; 3];
        let mut player = 'X';
        for m in moves {
            board[m[0] as usize][m[1] as usize] = player;
            if player == 'X' {
                player = 'O';
            } else {
                player = 'X';
            }
        }
        let mut winner = ' ';
        for i in 0..3 {
            if board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ' {
                winner = board[i][0];
            }
            if board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ' {
                winner = board[0][i];
            }
        }
        if board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ' {
            winner = board[0][0];
        }
        if board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ' {
            winner = board[0][2];
        }
        if winner == ' ' {
            if moves.len() == 9 {
                return "Draw".to_string();
            } else {
                return "Pending".to_string();
            }
        }
        if winner == 'X' {
            return "A".to_string();
        } else {
            return "B".to_string();
        }
    }
}