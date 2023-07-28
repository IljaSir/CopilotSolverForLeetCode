impl Solution {
    pub fn max_ascending_sum(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        for i in 0..nums.len() {
            if i == 0 || nums[i] > nums[i-1] {
                cur += nums[i];
            } else {
                max = std::cmp::max(max, cur);
                cur = nums[i];
            }
        }
        std::cmp::max(max, cur)
    }
}