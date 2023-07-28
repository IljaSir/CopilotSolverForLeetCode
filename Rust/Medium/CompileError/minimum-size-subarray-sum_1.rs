impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        

        let mut left = 0;
        let mut right = 0;
        let mut sum = 0;
        let mut result = std::i32::MAX;
        while right < nums.len() {
            sum += nums[right];
            right += 1;
            while sum >= target {
                result = result.min(right as i32 - left as i32);
                sum -= nums[left];
                left += 1;
            }
        }
        if result == std::i32::MAX {
            0
        } else {
            result
        }
    }
}