impl Solution {
    pub fn place_word_in_crossword(board: Vec<Vec<char>>, word: String) -> bool {
        
        let m = board.len();
        let n = board[0].len();
        let mut board = board;
        let mut word = word;
        let mut cnt = 0;
        let mut rows = vec![vec![]; m];
        let mut cols = vec![vec![]; n];
        for i in 0..m {
            for j in 0..n {
                if board[i][j] == ' ' {
                    cnt += 1;
                } else {
                    if cnt > 0 {
                        rows[i].push(cnt);
                    }
                    cnt = 0;
                }
            }
            if cnt > 0 {
                rows[i].push(cnt);
            }
            cnt = 0;
        }
        for j in 0..n {
            for i in 0..m {
                if board[i][j] == ' ' {
                    cnt += 1;
                } else {
                    if cnt > 0 {
                        cols[j].push(cnt);
                    }
                    cnt = 0;
                }
            }
            if cnt > 0 {
                cols[j].push(cnt);
            }
            cnt = 0;
        }
        for i in 0..m {
            for j in 0..n {
                if board[i][j] == ' ' {
                    for l in 0..rows[i].len() {
                        if rows[i][l] >= word.len() {
                            let mut flag = true;
                            for k in 0..word.len() {
                                if board[i][j + k] != ' ' && board[i][j + k] != word.chars().nth(k).unwrap() {
                                    flag = false;
                                    break;
                                }
                            }
                            if flag {
                                return true;
                            }
                        }
                    }
                    for l in 0..cols[j].len() {
                        if cols[j][l] >= word.len() {
                            let mut flag = true;
                            for k in 0..word.len() {
                                if board[i + k][j] != ' ' && board[i + k][j] != word.chars().nth(k).unwrap() {
                                    flag = false;
                                    break;
                                }
                            }
                            if flag {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        word = word.chars().rev().collect();
        for i in 0..m {
            for j in
    }
}