impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        

        let m = board.len();
        let n = board[0].len();
        let mut visited = vec![vec![false; n]; m];
        let word = word.chars().collect::<Vec<char>>();
        for i in 0..m {
            for j in 0..n {
                if Self::dfs(&board, &mut visited, &word, i, j, 0) {
                    return true;
                }
            }
        }
        false
    }
    fn dfs(board: &Vec<Vec<char>>, visited: &mut Vec<Vec<bool>>, word: &Vec<char>, i: usize, j: usize, k: usize) -> bool {
        if i >= board.len() || j >= board[i].len() || i < 0 || j < 0 || visited[i][j] || board[i][j] != word[k] {
            return false;
        }
        if k == word.len() - 1 {
            return true;
        }
        visited[i][j] = true;
        let res = Self::dfs(board, visited, word, i + 1, j, k + 1) ||
            Self::dfs(board, visited, word, i - 1, j, k + 1) ||
            Self::dfs(board, visited, word, i, j + 1, k + 1) ||
            Self::dfs(board, visited, word, i, j - 1, k + 1);
        visited[i][j] = false;
        return res;
    }
}