impl Solution {
    pub fn stone_game_v(stone_value: Vec<i32>) -> i32 {
        
        let n = stone_value.len();
        let mut dp = vec![vec![-1; n]; n];
        let mut sum = vec![0; n];
        sum[0] = stone_value[0];
        for i in 1..n {
            sum[i] = sum[i - 1] + stone_value[i];
        }
        Self::dfs(&stone_value, &mut dp, &sum, 0, n - 1)
    }
    fn dfs(stone_value: &Vec<i32>, dp: &mut Vec<Vec<i32>>, sum: &Vec<i32>, start: usize, end: usize) -> i32 {
        if start == end {
            return 0;
        }
        if dp[start][end] != -1 {
            return dp[start][end];
        }
        let mut ans = 0;
        let mut left = 0;
        let mut right = sum[end] - if start == 0 { 0 } else { sum[start - 1] };
        for i in start..end {
            left += stone_value[i];
            right -= stone_value[i];
            if left < right {
                ans = ans.max(left + Self::dfs(stone_value, dp, sum, start, i));
            } else if left > right {
                ans = ans.max(right + Self::dfs(stone_value, dp, sum, i + 1, end));
            } else {
                ans = ans.max(left + Self::dfs(stone_value, dp, sum, start, i));
                ans = ans.max(right + Self::dfs(stone_value, dp, sum, i + 1, end));
            }
        }
        dp[start][end] = ans;
        ans
    }
}