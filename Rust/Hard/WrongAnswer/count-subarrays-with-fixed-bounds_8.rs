impl Solution {
    pub fn count_subarrays(nums: Vec<i32>, min_k: i32, max_k: i32) -> i64 {
        
        let mut res = 0;
        let mut dp = vec![0; nums.len()];
        for i in 0..nums.len() {
            let mut min = nums[i];
            let mut max = nums[i];
            let mut j = i;
            while j < nums.len() {
                if nums[j] < min {
                    min = nums[j];
                }
                if nums[j] > max {
                    max = nums[j];
                }
                if min >= min_k && max <= max_k {
                    dp[j] += 1;
                    res += 1;
                } else {
                    break;
                }
                j += 1;
            }
        }
        res
    }
}