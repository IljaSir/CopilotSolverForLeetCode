impl Solution {
    pub fn exist(board: Vec<Vec<char>>, word: String) -> bool {
        

        let mut visited = vec![vec![false; board[0].len()]; board.len()];
        for i in 0..board.len() {
            for j in 0..board[0].len() {
                if Solution::dfs(&board, &word, i, j, &mut visited) {
                    return true;
                }
            }
        }
        false
    }
    
    fn dfs(board: &Vec<Vec<char>>, word: &String, i: usize, j: usize, visited: &mut Vec<Vec<bool>>) -> bool {
        if word.len() == 0 {
            return true;
        }
        if i >= board.len() || j >= board[0].len() || i < 0 || j < 0 || visited[i][j] || board[i][j] != word.chars().nth(0).unwrap() {
            return false;
        }
        visited[i][j] = true;
        let res = Solution::dfs(board, &word[1..].to_string(), i+1, j, visited) ||
            Solution::dfs(board, &word[1..].to_string(), i-1, j, visited) ||
            Solution::dfs(board, &word[1..].to_string(), i, j+1, visited) ||
            Solution::dfs(board, &word[1..].to_string(), i, j-1, visited);
        visited[i][j] = false;
        res
    }
}