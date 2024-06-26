impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut x = 0;
        let mut o = 0;
        let mut x_win = false;
        let mut o_win = false;
        for i in 0..3 {
            if board[i].starts_with("XXX") || board[i].ends_with("XXX") {
                x_win = true;
            }
            if board[i].starts_with("OOO") || board[i].ends_with("OOO") {
                o_win = true;
            }
            for j in 0..3 {
                if board[i].chars().nth(j).unwrap() == 'X' {
                    x += 1;
                } else if board[i].chars().nth(j).unwrap() == 'O' {
                    o += 1;
                }
                if i == j && (board[i].chars().nth(j).unwrap() == 'X') {
                    if board[0].chars().nth(0).unwrap() == 'X' && board[1].chars().nth(1).unwrap() == 'X' && board[2].chars().nth(2).unwrap() == 'X' {
                        x_win = true;
                    }
                }
                if i + j == 2 && (board[i].chars().nth(j).unwrap() == 'X') {
                    if board[0].chars().nth(2).unwrap() == 'X' && board[1].chars().nth(1).unwrap() == 'X' && board[2].chars().nth(0).unwrap() == 'X' {
                        x_win = true;
                    }
                }
                if i == j && (board[i].chars().nth(j).unwrap() == 'O') {
                    if board[0].chars().nth(0).unwrap() == 'O' && board[1].chars().nth(1).unwrap() == 'O' && board[2].chars().nth(2).unwrap() == 'O' {
                        o_win = true;
                    }
                }
                if i + j == 2 && (board[i].chars().nth(j).unwrap() == 'O') {
                    if board[0].chars().nth(2).unwrap() == 'O' && board[1].chars().nth(1).unwrap() == 'O' && board[2].chars().nth(0).unwrap() == 'O' {
                        o_win = true
    }
}