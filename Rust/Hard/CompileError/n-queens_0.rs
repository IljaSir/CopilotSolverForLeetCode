impl Solution {
    pub fn solve_n_queens(n: i32) -> Vec<Vec<String>> {
        
        let mut board = vec![vec!['.'; n as usize]; n as usize];
        let mut res = vec![];
        backtrack(&mut board, 0, &mut res);
        res
    }
}