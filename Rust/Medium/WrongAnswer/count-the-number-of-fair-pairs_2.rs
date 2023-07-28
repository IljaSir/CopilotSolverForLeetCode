impl Solution {
    pub fn count_fair_pairs(nums: Vec<i32>, lower: i32, upper: i32) -> i64 {
        
        let mut pairs = 0;
        let mut left = 0;
        let mut right = 0;
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            while left < i && sum - nums[left] >= lower {
                sum -= nums[left];
                left += 1;
            }
            while right < i && sum - nums[right] > upper {
                sum -= nums[right];
                right += 1;
            }
            pairs += (i - left) as i64;
            if left < right && sum - nums[right] >= lower {
                pairs -= 1;
            }
        }
        pairs
    }
}