impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        

        let word = word.as_bytes();
        let mut visited = vec![vec![false; board[0].len()]; board.len()];
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                if Self::dfs(&board, &mut visited, word, i, j, 0) {
                    return true;
                }
            }
        }
        false
    }
    
    fn dfs(board: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>, word: &[u8], i: usize, j: usize, index: usize) -> bool {
        if index == word.len() {
            return true;
        }
        if i >= board.len() || j >= board[0].len() || visited[i][j] || board[i][j] as u8 != word[index] {
            return false;
        }
        visited[i][j] = true;
        let result = Self::dfs(board, visited, word, i + 1, j, index + 1) || Self::dfs(board, visited, word, i, j + 1, index + 1) || Self::dfs(board, visited, word, i, j.checked_sub(1).unwrap_or(0), index + 1) || Self::dfs(board, visited, word, i.checked_sub(1).unwrap_or(0), j, index + 1);
        visited[i][j] = false;
        result
    }
}