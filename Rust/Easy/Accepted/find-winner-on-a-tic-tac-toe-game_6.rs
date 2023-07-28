impl Solution {
    pub fn tictactoe(moves: Vec<Vec<i32>>) -> String {
        
        let mut board = vec![vec![' '; 3]; 3];
        for (i, mv) in moves.iter().enumerate() {
            let r = mv[0] as usize;
            let c = mv[1] as usize;
            if i % 2 == 0 {
                board[r][c] = 'X';
            } else {
                board[r][c] = 'O';
            }
        }
        for i in 0..3 {
            if board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2] {
                return if board[i][0] == 'X' {
                    String::from("A")
                } else {
                    String::from("B")
                };
            }
            if board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i] {
                return if board[0][i] == 'X' {
                    String::from("A")
                } else {
                    String::from("B")
                };
            }
        }
        if board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2] {
            return if board[0][0] == 'X' {
                String::from("A")
            } else {
                String::from("B")
            };
        }
        if board[2][0] != ' ' && board[2][0] == board[1][1] && board[1][1] == board[0][2] {
            return if board[2][0] == 'X' {
                String::from("A")
            } else {
                String::from("B")
            };
        }
        if moves.len() == 9 {
            return String::from("Draw");
        }
        String::from("Pending")
    }
}