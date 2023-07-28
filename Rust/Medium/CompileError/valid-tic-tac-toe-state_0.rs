impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut x_count = 0;
        let mut o_count = 0;
        for i in 0..3 {
            for j in 0..3 {
                if board[i].as_bytes()[j] == b'X' {
                    x_count += 1;
                } else if board[i].as_bytes()[j] == b'O' {
                    o_count += 1;
                }
            }
        }
        if o_count != x_count && o_count != x_count - 1 {
            return false;
        }
        let mut x_win = false;
        let mut o_win = false;
        for i in 0..3 {
            if board[i].as_bytes()[0] == b'X' && board[i].as_bytes()[1] == b'X' && board[i].as_bytes()[2] == b'X' {
                x_win = true;
            }
            if board[i].as_bytes()[0] == b'O' && board[i].as_bytes()[1] == b'O' && board[i].as_bytes()[2] == b'O' {
                o_win = true;
            }
            if board[0].as_bytes()[i] == b'X' && board[1].as_bytes()[i] == b'X' && board[2].as_bytes()[i] == b'X' {
                x_win = true;
            }
            if board[0].as_bytes()[i] == b'O' && board[1].as_bytes()[i] == b'O' && board[2].as_bytes()[i] == b'O' {
                o_win = true;
            }
        }
        if board[0].as_bytes()[0] == b'X' && board[1].as_bytes()[1] == b'X' && board[2].as_bytes()[2] == b'X' {
            x_win = true;
        }
        if board[0].as_bytes()[0] == b'O' && board[1].as_bytes()[1] == b'O' && board[2].as_bytes()[2] == b'O' {
            o_win = true;
        }
        if board[0].as_bytes()[2] == b'X' && board[1].as_bytes()[1] == b'X' && board[2].as_bytes()[0] == b'X
    }
}