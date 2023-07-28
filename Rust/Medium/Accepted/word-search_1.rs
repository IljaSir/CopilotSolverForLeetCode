impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        

        let mut visited = vec![vec![false; board[0].len()]; board.len()];
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                if board[i][j] == word.chars().nth(0).unwrap() {
                    if Self::dfs(&board, &mut visited, &word, i, j, 0) {
                        return true;
                    }
                }
            }
        }
        false
    }
    fn dfs(board: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>, word: &String, i: usize, j: usize, idx: usize) -> bool {
        if idx == word.len() {
            return true;
        }
        if i < 0 || i >= board.len() || j < 0 || j >= board[0].len() || visited[i][j] {
            return false;
        }
        if board[i][j] != word.chars().nth(idx).unwrap() {
            return false;
        }
        visited[i][j] = true;
        let result = Self::dfs(board, visited, word, i + 1, j, idx + 1) || Self::dfs(board, visited, word, i - 1, j, idx + 1) || Self::dfs(board, visited, word, i, j + 1, idx + 1) || Self::dfs(board, visited, word, i, j - 1, idx + 1);
        visited[i][j] = false;
        result
    }
}