impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut x = 0;
        let mut o = 0;
        let mut x_win = false;
        let mut o_win = false;
        for i in 0..3 {
            if board[i].chars().nth(0) == board[i].chars().nth(1) && board[i].chars().nth(0) == board[i].chars().nth(2) {
                if board[i].chars().nth(0) == Some('X') {
                    x_win = true;
                } else if board[i].chars().nth(0) == Some('O') {
                    o_win = true;
                }
            }
            if board[0].chars().nth(i) == board[1].chars().nth(i) && board[0].chars().nth(i) == board[2].chars().nth(i) {
                if board[0].chars().nth(i) == Some('X') {
                    x_win = true;
                } else if board[0].chars().nth(i) == Some('O') {
                    o_win = true;
                }
            }
        }
        if board[0].chars().nth(0) == board[1].chars().nth(1) && board[0].chars().nth(0) == board[2].chars().nth(2) {
            if board[0].chars().nth(0) == Some('X') {
                x_win = true;
            } else if board[0].chars().nth(0) == Some('O') {
                o_win = true;
            }
        }
        if board[0].chars().nth(2) == board[1].chars().nth(1) && board[0].chars().nth(2) == board[2].chars().nth(0) {
            if board[0].chars().nth(2) == Some('X') {
                x_win = true;
            } else if board[0].chars().nth(2) == Some('O') {
                o_win = true;
            }
        }
        for i in 0..3 {
            for j in 0..3 {
                if board[i].chars().nth(j) == Some('X') {
                    x += 1;
                } else if board[i].chars().nth(j) == Some('O') {
                    o += 1;
                }
            }