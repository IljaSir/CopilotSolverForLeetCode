impl Solution {
    pub fn min_sum_of_lengths(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut dp = vec![0; arr.len()+1];
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, 0);
        let mut result = std::i32::MAX;
        let mut min = std::i32::MAX;
        for (i, &a) in arr.iter().enumerate() {
            sum += a;
            if let Some(&j) = map.get(&(sum - target)) {
                if j > 0 {
                    min = std::cmp::min(min, dp[j]);
                }
                dp[i+1] = if min == std::i32::MAX { std::i32::MAX } else { i as i32 - j as i32 + min + 2 };
                result = std::cmp::min(result, dp[i+1]);
            } else {
                dp[i+1] = std::i32::MAX;
            }
            map.insert(sum, i+1);
        }
        if result == std::i32::MAX {
            -1
        } else {
            result
        }
    }
}