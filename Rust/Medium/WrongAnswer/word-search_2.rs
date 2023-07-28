impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        

        let (m, n) = (board.len(), board[0].len());
        let mut visited = vec![vec![false; n]; m];
        for i in 0..m {
            for j in 0..n {
                if Self::dfs(&board, &mut visited, &word, i, j, 0) {
                    return true;
                }
            }
        }
        false
    }
    fn dfs(board: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>, word: &String, i: usize, j: usize, k: usize) -> bool {
        if k == word.len() {
            return true;
        }
        if i == board.len() || j == board[0].len() || i == 0 || j == 0 {
            return false;
        }
        if visited[i][j] || board[i][j] != word.as_bytes()[k] as char {
            return false;
        }
        visited[i][j] = true;
        let res = Self::dfs(board, visited, word, i + 1, j, k + 1)
            || Self::dfs(board, visited, word, i - 1, j, k + 1)
            || Self::dfs(board, visited, word, i, j + 1, k + 1)
            || Self::dfs(board, visited, word, i, j - 1, k + 1);
        visited[i][j] = false;
        res
    }
}