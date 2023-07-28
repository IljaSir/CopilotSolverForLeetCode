impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut x = 0;
        let mut o = 0;
        let mut win = 0;
        for i in 0..3 {
            for j in 0..3 {
                if board[i].chars().nth(j).unwrap() == 'X' {
                    x += 1;
                }
                if board[i].chars().nth(j).unwrap() == 'O' {
                    o += 1;
                }
            }
        }
        if o > x || x - o > 1 {
            return false;
        }
        for i in 0..3 {
            if board[i].chars().nth(0).unwrap() != ' ' && board[i].chars().nth(0).unwrap() == board[i].chars().nth(1).unwrap() && board[i].chars().nth(0).unwrap() == board[i].chars().nth(2).unwrap() {
                win += 1;
            }
            if board[0].chars().nth(i).unwrap() != ' ' && board[0].chars().nth(i).unwrap() == board[1].chars().nth(i).unwrap() && board[0].chars().nth(i).unwrap() == board[2].chars().nth(i).unwrap() {
                win += 1;
            }
        }
        if board[0].chars().nth(0).unwrap() != ' ' && board[0].chars().nth(0).unwrap() == board[1].chars().nth(1).unwrap() && board[0].chars().nth(0).unwrap() == board[2].chars().nth(2).unwrap() {
            win += 1;
        }
        if board[0].chars().nth(2).unwrap() != ' ' && board[0].chars().nth(2).unwrap() == board[1].chars().nth(1).unwrap() && board[0].chars().nth(2).unwrap() == board[2].chars().nth(0).unwrap() {
            win += 1;
        }
        if win == 0 {
            return true;
        }
        if win == 1 {
            if x == o {
                return false;
            }
            return true;
        }
        if win == 2 {
            return false;
        }
        false
    }
}