impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let mut one_count = 0;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                one_count += 1;
            }
        }
        let mut left = 0;
        let mut right = 0;
        let mut max_one_count = 0;
        while right < nums.len() {
            if nums[right] == 1 {
                max_one_count += 1;
            }
            if right - left + 1 == one_count {
                break;
            }
            right += 1;
        }
        let mut result = one_count - max_one_count;
        while right < nums.len() {
            if nums[left] == 1 {
                max_one_count -= 1;
            }
            left += 1;
            right += 1;
            if right < nums.len() && nums[right] == 1 {
                max_one_count += 1;
            }
            result = std::cmp::min(result, one_count - max_one_count);
        }
        result as i32
    }
}