impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut left = k;
        let mut right = k;
        let mut min_val = nums[k];
        let mut max_score = min_val;
        while left > 0 || right < nums.len() - 1 {
            let left_val = if left == 0 { std::i32::MAX } else { nums[left - 1] };
            let right_val = if right == nums.len() - 1 { std::i32::MAX } else { nums[right + 1] };
            if left_val < right_val {
                right += 1;
                min_val = min_val.min(nums[right]);
            } else {
                left -= 1;
                min_val = min_val.min(nums[left]);
            }
            max_score = max_score.max(min_val * (right - left + 1) as i32);
        }
        max_score
    }
}