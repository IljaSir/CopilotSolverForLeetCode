impl Solution {
    pub fn max_jumps(arr: Vec<i32>, d: i32) -> i32 {
        
        let n = arr.len();
        let mut dp = vec![1; n];
        let mut sorted = (0..n).collect::<Vec<usize>>();
        sorted.sort_by_key(|&i| arr[i]);
        for i in sorted {
            for j in (i+1..=i+d.min(n as i32-1-i as i32) as usize).rev() {
                if arr[i] <= arr[j] {
                    break;
                }
                dp[i] = dp[i].max(dp[j] + 1);
            }
            for j in i+1..i+d.min(n as i32-1-i as i32) as usize {
                if arr[i] <= arr[j] {
                    break;
                }
                dp[i] = dp[i].max(dp[j] + 1);
            }
        }
        dp.into_iter().max().unwrap()
    }
}