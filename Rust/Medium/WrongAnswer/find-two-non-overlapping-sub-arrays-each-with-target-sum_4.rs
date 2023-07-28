impl Solution {
    pub fn min_sum_of_lengths(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut dp = vec![0; arr.len() + 1];
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        let mut ans = std::i32::MAX;
        let mut min = std::i32::MAX;
        for i in 0..arr.len() {
            sum += arr[i];
            if sum == target {
                dp[i + 1] = i as i32 + 1;
            } else if let Some(&j) = map.get(&(sum - target)) {
                dp[i + 1] = i as i32 - j;
            }
            if dp[i + 1] > 0 {
                if min != std::i32::MAX {
                    ans = ans.min(min + dp[i + 1]);
                }
                min = min.min(dp[i + 1]);
            }
            map.insert(sum, i as i32);
        }
        if ans == std::i32::MAX {
            -1
        } else {
            ans
        }
    }
}