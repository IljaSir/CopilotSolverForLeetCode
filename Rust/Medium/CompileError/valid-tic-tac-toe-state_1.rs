impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut x_count = 0;
        let mut o_count = 0;
        for row in board.iter() {
            for c in row.chars() {
                match c {
                    'X' => x_count += 1,
                    'O' => o_count += 1,
                    _ => {}
                }
            }
        }
        if x_count < o_count || x_count > o_count + 1 {
            return false;
        }
        let winner = Self::get_winner(&board);
        if winner == Some('X') {
            x_count == o_count + 1
        } else if winner == Some('O') {
            x_count == o_count
        } else {
            true
        }
    }
}