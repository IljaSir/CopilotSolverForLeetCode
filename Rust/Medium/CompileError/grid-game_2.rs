impl Solution {
    pub fn grid_game(grid: Vec<Vec<i32>>) -> i64 {
        
        let n = grid[0].len();
        let mut prefix = vec![0; n + 1];
        for i in 0..n {
            prefix[i + 1] = prefix[i] + grid[0][i];
        }
        let mut suffix = vec![0; n + 1];
        for i in (0..n).rev() {
            suffix[i] = suffix[i + 1] + grid[1][i];
        }
        let mut ans = std::i64::MAX;
        for i in 0..n {
            ans = ans.min(prefix[i] + suffix[i + 1]);
        }
        ans
    }
}