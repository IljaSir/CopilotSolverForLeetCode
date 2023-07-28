impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        
        let mut board = vec![vec![' '; 3]; 3];
        for (i, mv) in moves.iter().enumerate() {
            board[mv[0] as usize][mv[1] as usize] = if i % 2 == 0 {'X'} else {'O'};
        }
        let mut winner = ' ';
        for i in 0..3 {
            if board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] != ' ' {
                winner = board[i][0];
                break;
            }
            if board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] != ' ' {
                winner = board[0][i];
                break;
            }
        }
        if board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != ' ' {
            winner = board[0][0];
        }
        if board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] != ' ' {
            winner = board[0][2];
        }
        if winner != ' ' {
            return String::from(if winner == 'X' {"A"} else {"B"});
        }
        if moves.len() == 9 {
            return String::from("Draw");
        }
        String::from("Pending")
    }
}