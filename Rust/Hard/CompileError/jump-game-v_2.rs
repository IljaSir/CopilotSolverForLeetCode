impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let mut dp = vec![0; arr.len()];
        let mut res = 0;
        for i in 0..arr.len() {
            res = res.max(Solution::dfs(i, &arr, &mut dp, d));
        }
        res
    }
    fn dfs(i: usize, arr: &Vec<i32>, dp: &mut Vec<i32>, d: i32) -> i32 {
        if dp[i] != 0 {
            return dp[i];
        }
        let mut res = 0;
        for j in 1..=d {
            if i + j >= arr.len() || arr[i + j] >= arr[i] {
                break;
            }
            res = res.max(Solution::dfs(i + j, arr, dp, d));
        }
        for j in 1..=d {
            if i < j || arr[i - j] >= arr[i] {
                break;
            }
            res = res.max(Solution::dfs(i - j, arr, dp, d));
        }
        dp[i] = res + 1;
        dp[i]
    }
}