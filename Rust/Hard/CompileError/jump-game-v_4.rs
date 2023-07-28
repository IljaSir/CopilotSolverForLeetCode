impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let mut dp = vec![0; arr.len()];
        let mut ans = 0;
        for &i in &arr.iter().enumerate().map(|(i, _)| i).collect::<Vec<_>>() {
            ans = ans.max(Solution::dfs(i, &arr, d, &mut dp));
        }
        ans
    }
    fn dfs(i: usize, arr: &Vec<i32>, d: i32, dp: &mut Vec<i32>) -> i32 {
        if dp[i] > 0 {
            return dp[i];
        }
        dp[i] = 1;
        for j in 1..=d {
            if i + j < arr.len() && arr[i + j] < arr[i] {
                dp[i] = dp[i].max(Solution::dfs(i + j, arr, d, dp) + 1);
            } else {
                break;
            }
        }
        for j in 1..=d {
            if i >= j && arr[i - j] < arr[i] {
                dp[i] = dp[i].max(Solution::dfs(i - j, arr, d, dp) + 1);
            } else {
                break;
            }
        }
        dp[i]
    }
}