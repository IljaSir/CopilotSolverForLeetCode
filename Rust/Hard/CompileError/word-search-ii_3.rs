impl Solution {
    pub fn find_words(board: Vec<Vec<char>>, words: Vec<String>) -> Vec<String> {
        
        let mut trie = Trie::new();
        for word in words {
            trie.insert(word);
        }
        let mut res = vec![];
        let mut visited = vec![vec![false; board[0].len()]; board.len()];
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                Self::dfs(&board, &mut visited, &mut trie, &mut res, i, j, vec![]);
            }
        }
        res
    }
    fn dfs(board: &[Vec<char>], visited: &mut Vec<Vec<bool>>, trie: &mut Trie, res: &mut Vec<String>, i: usize, j: usize, mut path: Vec<char>) {
        if i >= board.len() || j >= board[0].len() || visited[i][j] {
            return;
        }
        path.push(board[i][j]);
        if !trie.starts_with(&path) {
            return;
        }
        if trie.search(&path) && !res.contains(&path.iter().collect()) {
            res.push(path.iter().collect());
        }
        visited[i][j] = true;
        Self::dfs(board, visited, trie, res, i + 1, j, path.clone());
        Self::dfs(board, visited, trie, res, i, j + 1, path.clone());
        Self::dfs(board, visited, trie, res, i, j.checked_sub(1).unwrap_or(0), path.clone());
        Self::dfs(board, visited, trie, res, i.checked_sub(1).unwrap_or(0), j, path.clone());
        visited[i][j] = false;
    }
}