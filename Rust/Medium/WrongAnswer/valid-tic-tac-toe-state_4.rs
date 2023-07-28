impl Solution {
    pub fn valid_tic_tac_toe(board: Vec<String>) -> bool {
        
        let mut x = 0;
        let mut o = 0;
        let mut row = vec![0; 3];
        let mut col = vec![0; 3];
        let mut diagonal = 0;
        let mut anti_diagonal = 0;

        for (i, b) in board.iter().enumerate() {
            for (j, c) in b.chars().enumerate() {
                if c == 'X' {
                    x += 1;
                    row[i] += 1;
                    col[j] += 1;
                    if i == j {
                        diagonal += 1;
                    }
                    if i + j == 2 {
                        anti_diagonal += 1;
                    }
                } else if c == 'O' {
                    o += 1;
                    row[i] -= 1;
                    col[j] -= 1;
                    if i == j {
                        diagonal -= 1;
                    }
                    if i + j == 2 {
                        anti_diagonal -= 1;
                    }
                }
            }
        }

        if o > x || x - o > 1 {
            return false;
        }

        if row.iter().any(|&x| x == 3) || col.iter().any(|&x| x == 3) || diagonal == 3 || anti_diagonal == 3 {
            if o == x {
                return false;
            }
        } else if row.iter().any(|&x| x == -3) || col.iter().any(|&x| x == -3) || diagonal == -3 || anti_diagonal == -3 {
            if o != x {
                return false;
            }
        }

        true
    }
}