impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut x = 0;
        let mut o = 0;
        let mut win = 0;
        for i in 0..3 {
            if board[i].starts_with("XXX") || board[i].ends_with("XXX") {
                win += 1;
            }
            if board[i].starts_with("OOO") || board[i].ends_with("OOO") {
                win -= 1;
            }
            for j in 0..3 {
                if board[i].chars().nth(j).unwrap() == 'X' {
                    x += 1;
                } else if board[i].chars().nth(j).unwrap() == 'O' {
                    o += 1;
                }
            }
            if board[0].chars().nth(i).unwrap() == board[1].chars().nth(i).unwrap() && board[1].chars().nth(i).unwrap() == board[2].chars().nth(i).unwrap() {
                if board[0].chars().nth(i).unwrap() == 'X' {
                    win += 1;
                } else if board[0].chars().nth(i).unwrap() == 'O' {
                    win -= 1;
                }
            }
        }
        if board[0].chars().nth(0).unwrap() == board[1].chars().nth(1).unwrap() && board[1].chars().nth(1).unwrap() == board[2].chars().nth(2).unwrap() {
            if board[0].chars().nth(0).unwrap() == 'X' {
                win += 1;
            } else if board[0].chars().nth(0).unwrap() == 'O' {
                win -= 1;
            }
        }
        if board[0].chars().nth(2).unwrap() == board[1].chars().nth(1).unwrap() && board[1].chars().nth(1).unwrap() == board[2].chars().nth(0).unwrap() {
            if board[0].chars().nth(2).unwrap() == 'X' {
                win += 1;
            } else if board[0].chars().nth(2).unwrap() == 'O' {
                win -= 1;
            }
        }
        if win > 0 || win < 0 && o >= x {
            return false;
    }
}