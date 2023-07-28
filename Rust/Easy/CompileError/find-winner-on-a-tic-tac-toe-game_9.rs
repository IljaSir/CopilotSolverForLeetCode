impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        
        let mut board = vec![vec![' '; 3]; 3];
        let mut player = 'X';
        for mv in moves {
            let (row, col) = (mv[0] as usize, mv[1] as usize);
            board[row][col] = player;
            if player == 'X' {
                player = 'O';
            } else {
                player = 'X';
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')
            || (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return board[1][1].to_string();
        }
        for i in 0..3 {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')
                || (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return board[i][0].to_string();
            }
        }
        if moves.len() == 9 {
            return "Draw".to_string();
        } else {
            return "Pending".to_string();
        }
    }
}