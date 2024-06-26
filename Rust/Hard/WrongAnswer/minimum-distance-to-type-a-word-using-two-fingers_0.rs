impl Solution {
    pub fn minimum_distance(word: String) -> i32 {
        
        let mut dp = vec![vec![-1; 26]; 26];
        let mut res = i32::MAX;
        for i in 0..26 {
            for j in 0..26 {
                res = res.min(Self::dfs(&word, &mut dp, i, j, 0));
            }
        }
        res
    }
    fn dfs(word: &str, dp: &mut Vec<Vec<i32>>, l: usize, r: usize, i: usize) -> i32 {
        if i == word.len() {
            return 0;
        }
        if dp[l][r] != -1 {
            return dp[l][r];
        }
        let mut res = i32::MAX;
        for j in 0..26 {
            let cost = Self::dist(l, j) + Self::dfs(word, dp, j, r, i + 1);
            res = res.min(cost);
        }
        for j in 0..26 {
            let cost = Self::dist(r, j) + Self::dfs(word, dp, l, j, i + 1);
            res = res.min(cost);
        }
        dp[l][r] = res;
        res
    }
    fn dist(l: usize, r: usize) -> i32 {
        if l == r {
            return 0;
        }
        let l = l as i32;
        let r = r as i32;
        let x = (l / 6 - r / 6).abs();
        let y = (l % 6 - r % 6).abs();
        x + y
    }
}