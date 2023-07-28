impl Solution {
    pub fn find_words(board: Vec<Vec<char>>, words: Vec<String>) -> Vec<String> {
        
        let mut trie = Trie::new();
        for word in words {
            trie.insert(word);
        }
        let mut result = vec![];
        let mut visited = vec![vec![false; board[0].len()]; board.len()];
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                let mut path = vec![];
                Solution::dfs(&board, &mut visited, i, j, &mut trie.root, &mut path, &mut result);
            }
        }
        result
    }

    pub fn dfs(
        board: &Vec<Vec<char>>,
        visited: &mut Vec<Vec<bool>>,
        i: usize,
        j: usize,
        trie_node: &mut TrieNode,
        path: &mut Vec<char>,
        result: &mut Vec<String>,
    ) {
        if i >= board.len() || j >= board[0].len() || visited[i][j] {
            return;
        }
        let c = board[i][j];
        if !trie_node.children.contains_key(&c) {
            return;
        }
        path.push(c);
        visited[i][j] = true;
        let mut node = trie_node.children.get_mut(&c).unwrap();
        if node.is_end {
            result.push(path.iter().collect());
            node.is_end = false;
        }
        Solution::dfs(board, visited, i + 1, j, node, path, result);
        Solution::dfs(board, visited, i, j + 1, node, path, result);
        Solution::dfs(board, visited, i, j.checked_sub(1).unwrap_or(0), node, path, result);
        Solution::dfs(board, visited, i.checked_sub(1).unwrap_or(0), j, node, path, result);
        visited[i][j] = false;
        path.pop();
    }
}