impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut res = 0;
        for i in (0..nums.len()).step_by(2) {
            let mut min = i32::max_value();
            if i > 0 {
                min = min.min(nums[i - 1]);
            }
            if i + 1 < nums.len() {
                min = min.min(nums[i + 1]);
            }
            if nums[i] >= min {
                res += nums[i] - min + 1;
            }
        }
        let mut res1 = 0;
        for i in (1..nums.len()).step_by(2) {
            let mut min = i32::max_value();
            if i > 0 {
                min = min.min(nums[i - 1]);
            }
            if i + 1 < nums.len() {
                min = min.min(nums[i + 1]);
            }
            if nums[i] >= min {
                res1 += nums[i] - min + 1;
            }
        }
        res.min(res1)
    }
}