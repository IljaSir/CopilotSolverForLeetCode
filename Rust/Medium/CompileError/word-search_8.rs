impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        

        let mut board = board;
        let mut word = word;
        let mut word = word.as_bytes();
        let mut word = word.to_vec();
        let mut word = word.iter().map(|x| *x as char).collect::<Vec<char>>();
        let mut board = board.iter_mut().map(|x| x.iter_mut().collect::<Vec<&mut char>>()).collect::<Vec<Vec<&mut char>>>();
        let mut result = false;
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                if Self::search(&mut board, &mut word, i, j, 0) {
                    result = true;
                    break;
                }
            }
        }
        result
    }
    
    fn search(board: &mut Vec<Vec<&mut char>>, word: &mut Vec<char>, i: usize, j: usize, k: usize) -> bool {
        if i >= board.len() || j >= board[0].len() || i < 0 || j < 0 || board[i][j] != &word[k] {
            return false;
        }
        if k == word.len() - 1 {
            return true;
        }
        let tmp = board[i][j];
        board[i][j] = &'#';
        let result = Self::search(board, word, i + 1, j, k + 1) || Self::search(board, word, i, j + 1, k + 1) || Self::search(board, word, i - 1, j, k + 1) || Self::search(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        result
    }
}