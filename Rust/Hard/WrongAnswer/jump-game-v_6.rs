impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![0; n];
        let mut res = 0;
        let mut arr = arr;
        arr.push(i32::MAX);
        for i in 0..n {
            res = res.max(Solution::dfs(i, &arr, d as usize, &mut dp));
        }
        res
    }
    fn dfs(i: usize, arr: &[i32], d: usize, dp: &mut Vec<i32>) -> i32 {
        if dp[i] != 0 {
            return dp[i];
        }
        let mut res = 1;
        for j in (i + 1).min(arr.len() - 1)..(i + d + 1).min(arr.len()) {
            if arr[i] <= arr[j] {
                break;
            }
            res = res.max(1 + Solution::dfs(j, arr, d, dp));
        }
        for j in (i + 1).min(arr.len() - 1)..(i + d + 1).min(arr.len()) {
            if arr[i] <= arr[j] {
                break;
            }
            res = res.max(1 + Solution::dfs(j, arr, d, dp));
        }
        dp[i] = res;
        res
    }
}