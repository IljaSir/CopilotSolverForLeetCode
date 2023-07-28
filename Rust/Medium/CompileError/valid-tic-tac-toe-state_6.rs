impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut x_count = 0;
        let mut o_count = 0;
        let mut x_win = false;
        let mut o_win = false;
        for i in 0..3 {
            if board[i].starts_with("XXX") {
                x_win = true;
            }
            if board[i].starts_with("OOO") {
                o_win = true;
            }
            if board[i].ends_with("XXX") {
                x_win = true;
            }
            if board[i].ends_with("OOO") {
                o_win = true;
            }
            if board[i].chars().nth(1) == Some('X') && board[i].chars().nth(1) == board[i].chars().nth(2) && board[i].chars().nth(2) == board[i].chars().nth(3) {
                x_win = true;
            }
            if board[i].chars().nth(1) == Some('O') && board[i].chars().nth(1) == board[i].chars().nth(2) && board[i].chars().nth(2) == board[i].chars().nth(3) {
                o_win = true;
            }
            if board[0].chars().nth(i) == Some('X') && board[1].chars().nth(i) == Some('X') && board[2].chars().nth(i) == Some('X') {
                x_win = true;
            }
            if board[0].chars().nth(i) == Some('O') && board[1].chars().nth(i) == Some('O') && board[2].chars().nth(i) == Some('O') {
                o_win = true;
            }
            x_count += board[i].matches("X").count();
            o_count += board[i].matches("O").count();
        }
        if board[0].chars().nth(1) == Some('X') && board[1].chars().nth(2) == Some('X') && board[2].chars().nth(3) == Some('X') {
            x_win = true;
        }
        if board[0].chars().nth(3) == Some('X') && board[1].chars().nth(2) == Some('X') && board[2].chars().nth(1) == Some('X') {
            x
    }
}