impl Solution {
    pub fn minimum_replacement(nums: Vec<i32>) -> i64 {
        
        let mut dp = vec![0; nums.len()];
        dp[0] = 0;
        for i in 1..nums.len() {
            if nums[i] > nums[i-1] {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-1] + 1;
                let mut j = i;
                while j > 0 && nums[j] < nums[j-1] {
                    nums.swap(j, j-1);
                    j -= 1;
                }
            }
        }
        dp[nums.len()-1] as i64
    }
}