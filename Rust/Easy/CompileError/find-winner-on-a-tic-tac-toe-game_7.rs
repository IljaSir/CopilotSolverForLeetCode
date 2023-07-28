impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        
        let mut board: Vec<Vec<char>> = vec![vec![' '; 3]; 3];
        let mut player = 'X';
        for mv in moves {
            board[mv[0] as usize][mv[1] as usize] = player;
            if player == 'X' {
                player = 'O';
            } else {
                player = 'X';
            }
        }
        for i in 0..3 {
            if board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ' {
                return String::from(board[i][0]);
            }
            if board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ' {
                return String::from(board[0][i]);
            }
        }
        if board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ' {
            return String::from(board[0][0]);
        }
        if board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != ' ' {
            return String::from(board[2][0]);
        }
        if moves.len() == 9 {
            return String::from("Draw");
        }
        return String::from("Pending");
    }
}