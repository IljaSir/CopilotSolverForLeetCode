impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![0; n];
        let mut res = 0;
        for i in 0..n {
            res = res.max(Self::dfs(i, &arr, d as usize, &mut dp));
        }
        res
    }
    fn dfs(i: usize, arr: &Vec<i32>, d: usize, dp: &mut Vec<i32>) -> i32 {
        if dp[i] > 0 {
            return dp[i];
        }
        let mut res = 1;
        for j in (i+1).min(arr.len()).saturating_sub(d)..=i+d {
            if i != j && arr[i] > arr[j] {
                res = res.max(Self::dfs(j, arr, d, dp) + 1);
            }
        }
        dp[i] = res;
        res
    }
}