impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![0; n];
        let mut ans = 0;
        for i in 0..n {
            ans = ans.max(Solution::dfs(i, &arr, &mut dp, d));
        }
        ans
    }
    fn dfs(i: usize, arr: &Vec<i32>, dp: &mut Vec<i32>, d: i32) -> i32 {
        if dp[i] > 0 { return dp[i]; }
        let n = arr.len();
        let mut ans = 1;
        for j in (i as i32 - d).max(0) as usize..i {
            if arr[j] >= arr[i] { continue; }
            ans = ans.max(1 + Solution::dfs(j, arr, dp, d));
        }
        for j in i + 1..(i as i32 + d).min(n as i32) as usize {
            if arr[j] >= arr[i] { continue; }
            ans = ans.max(1 + Solution::dfs(j, arr, dp, d));
        }
        dp[i] = ans;
        ans
    }
}