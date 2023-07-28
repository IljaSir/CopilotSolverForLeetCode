impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        

        let m = board.len();
        let n = board[0].len();
        let mut visited = vec![vec![false; n]; m];
        let mut result = false;
        for i in 0..m {
            for j in 0..n {
                if board[i][j] == word.chars().nth(0).unwrap() {
                    visited[i][j] = true;
                    result = result || Self::find_word(&board, &mut visited, &word[1..], i, j);
                    visited[i][j] = false;
                }
            }
        }
        result
    }
    
    fn find_word(board: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>, word: &str, i: usize, j: usize) -> bool {
        if word.len() == 0 {
            return true;
        }
        let m = board.len();
        let n = board[0].len();
        let mut result = false;
        if i > 0 && !visited[i-1][j] && board[i-1][j] == word.chars().nth(0).unwrap() {
            visited[i-1][j] = true;
            result = result || Self::find_word(board, visited, &word[1..], i-1, j);
            visited[i-1][j] = false;
        }
        if i < m-1 && !visited[i+1][j] && board[i+1][j] == word.chars().nth(0).unwrap() {
            visited[i+1][j] = true;
            result = result || Self::find_word(board, visited, &word[1..], i+1, j);
            visited[i+1][j] = false;
        }
        if j > 0 && !visited[i][j-1] && board[i][j-1] == word.chars().nth(0).unwrap() {
            visited[i][j-1] = true;
            result = result || Self::find_word(board, visited, &word[1..], i, j-1);
            visited[i][j-1] = false;
        }
        if j < n-1 && !visited[i][j+1] && board[i][j+1] == word.chars().nth(0).unwrap() {
            visited[i][j+1] =
    }
}