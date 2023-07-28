impl Solution {
    pub fn maximum_score(nums: Vec<i32>, k: i32) -> i32 {
        
        let k = k as usize;
        let mut left = k;
        let mut right = k;
        let mut max = nums[k];
        let mut min = nums[k];
        while left > 0 || right < nums.len() - 1 {
            if left == 0 {
                right += 1;
            } else if right == nums.len() - 1 {
                left -= 1;
            } else if nums[left-1] < nums[right+1] {
                right += 1;
            } else {
                left -= 1;
            }
            min = std::cmp::min(min, nums[left]);
            min = std::cmp::min(min, nums[right]);
            max = std::cmp::max(max, min * (right - left + 1) as i32);
        }
        max
    }
}