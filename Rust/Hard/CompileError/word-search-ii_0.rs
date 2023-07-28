impl Solution {
    pub fn find_words(board: Vec<Vec<char>>, words: Vec<String>) -> Vec<String> {
        
        let mut trie = Trie::new();
        for word in words {
            trie.insert(word);
        }
        let mut ans = vec![];
        for i in 0..board.len() {
            for j in 0..board[i].len() {
                trie.search(&board, i, j, &mut ans);
            }
        }
        ans
    }
}