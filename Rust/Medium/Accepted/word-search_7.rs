impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        

        let word = word.chars().collect::<Vec<char>>();
        let mut board = board;
        for i in 0..board.len() {
            for j in 0..board[i].len() {
                if word[0] == board[i][j] {
                    if Solution::search(&mut board, &word, i, j, 0) {
                        return true;
                    }
                }
            }
        }
        false
    }
    fn search(board: &mut Vec<Vec<char>>, word: &Vec<char>, i: usize, j: usize, index: usize) -> bool {
        if index == word.len() {
            return true;
        }
        if i >= board.len() || j >= board[i].len() || board[i][j] != word[index] {
            return false;
        }
        let c = board[i][j];
        board[i][j] = ' ';
        let result = Solution::search(board, word, i + 1, j, index + 1)
            || Solution::search(board, word, i, j + 1, index + 1)
            || Solution::search(board, word, i, j.checked_sub(1).unwrap_or(0), index + 1)
            || Solution::search(board, word, i.checked_sub(1).unwrap_or(0), j, index + 1);
        board[i][j] = c;
        result
    }
}