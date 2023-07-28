impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut count_x = 0;
        let mut count_o = 0;
        let mut win_x = false;
        let mut win_o = false;
        for i in 0..3 {
            let mut row_x = true;
            let mut row_o = true;
            let mut col_x = true;
            let mut col_o = true;
            for j in 0..3 {
                match board[i].as_bytes()[j] {
                    b'X' => {
                        count_x += 1;
                    },
                    b'O' => {
                        count_o += 1;
                    },
                    _ => {}
                }
                if board[i].as_bytes()[j] != b'X' {
                    row_x = false;
                }
                if board[i].as_bytes()[j] != b'O' {
                    row_o = false;
                }
                if board[j].as_bytes()[i] != b'X' {
                    col_x = false;
                }
                if board[j].as_bytes()[i] != b'O' {
                    col_o = false;
                }
            }
            if row_x {
                win_x = true;
            }
            if row_o {
                win_o = true;
            }
            if col_x {
                win_x = true;
            }
            if col_o {
                win_o = true;
            }
        }
        if board[0].as_bytes()[0] == b'X' && board[1].as_bytes()[1] == b'X' && board[2].as_bytes()[2] == b'X' {
            win_x = true;
        }
        if board[0].as_bytes()[0] == b'O' && board[1].as_bytes()[1] == b'O' && board[2].as_bytes()[2] == b'O' {
            win_o = true;
        }
        if board[0].as_bytes()[2] == b'X' && board[1].as_bytes()[1] == b'X' && board[2].as_bytes()[0] == b'X' {
            win_x = true;
        }
        if board[0].as_bytes()[2] == b'O' && board[1].as_bytes()[1] == b'O' && board[2].as_bytes()[0] == b'O' {
            win_o = true;
        }
        if count
    }
}