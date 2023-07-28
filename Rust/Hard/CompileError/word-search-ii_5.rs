impl Solution {
    pub fn find_words(board: Vec<Vec<char>>, words: Vec<String>) -> Vec<String> {
        
        let mut trie = Trie::new();
        for word in words {
            trie.add(word);
        }
        let mut result = vec![];
        let mut visited = vec![vec![false; board[0].len()]; board.len()];
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                trie.search(&board, &mut visited, i, j, &mut result);
            }
        }
        result
    }
}