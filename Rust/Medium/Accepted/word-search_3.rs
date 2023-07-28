impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        

        let mut visited = vec![vec![false; board[0].len()]; board.len()];
        for i in 0..board.len() {
            for j in 0..board[i].len() {
                if Self::dfs(&board, &word, i, j, 0, &mut visited) {
                    return true;
                }
            }
        }
        false
    }
    
    fn dfs(board: &Vec<Vec<char>>, word: &String, i: usize, j: usize, k: usize, visited: &mut Vec<Vec<bool>>) -> bool {
        if i >= board.len() || j >= board[i].len() || visited[i][j] || board[i][j] != word.as_bytes()[k] as char {
            return false;
        }
        if k == word.len() - 1 {
            return true;
        }
        visited[i][j] = true;
        let res = Self::dfs(board, word, i + 1, j, k + 1, visited) || Self::dfs(board, word, i, j + 1, k + 1, visited) || Self::dfs(board, word, i - 1, j, k + 1, visited) || Self::dfs(board, word, i, j - 1, k + 1, visited);
        visited[i][j] = false;
        res
    }
}