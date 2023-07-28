impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        
        let mut board = vec![vec![' '; 3]; 3];
        for (i, m) in moves.iter().enumerate() {
            let c = if i % 2 == 0 { 'X' } else { 'O' };
            board[m[0] as usize][m[1] as usize] = c;
        }
        for i in 0..3 {
            if board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2] {
                return board[i][0].to_string();
            }
            if board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i] {
                return board[0][i].to_string();
            }
        }
        if board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] {
            return board[0][0].to_string();
        }
        if board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0] {
            return board[0][2].to_string();
        }
        if moves.len() == 9 {
            "Draw".to_string()
        } else {
            "Pending".to_string()
        }
    }
}