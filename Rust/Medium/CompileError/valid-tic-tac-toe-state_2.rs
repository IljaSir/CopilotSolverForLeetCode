impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut xs = 0;
        let mut os = 0;
        let mut rows = vec![0; 3];
        let mut cols = vec![0; 3];
        let mut diag = 0;
        let mut anti_diag = 0;
        for (i, row) in board.iter().enumerate() {
            for (j, c) in row.chars().enumerate() {
                if c == 'X' {
                    xs += 1;
                    rows[i] += 1;
                    cols[j] += 1;
                    if i == j {
                        diag += 1;
                    }
                    if i + j == 2 {
                        anti_diag += 1;
                    }
                } else if c == 'O' {
                    os += 1;
                    rows[i] -= 1;
                    cols[j] -= 1;
                    if i == j {
                        diag -= 1;
                    }
                    if i + j == 2 {
                        anti_diag -= 1;
                    }
                }
            }
        }
        if (xs - os).abs() > 1 {
            return false;
        }
        if xs > os && rows.iter().any(|&x| x == 3) {
            return false;
        }
        if xs > os && cols.iter().any(|&x| x == 3) {
            return false;
        }
        if xs > os && diag == 3 {
            return false;
        }
        if xs > os && anti_diag == 3 {
            return false;
        }
        if os > xs && rows.iter().any(|&x| x == -3) {
            return false;
        }
        if os > xs && cols.iter().any(|&x| x == -3) {
            return false;
        }
        if os > xs && diag == -3 {
            return false;
        }
        if os > xs && anti_diag == -3 {
            return false;
        }
        true
    }
}