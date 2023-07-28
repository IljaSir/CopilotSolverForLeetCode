impl Solution {
    pub fn destroy_targets(nums: Vec<i32>, space: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut count = 1;
        let mut max = 1;
        for i in 1..nums.len() {
            if nums[i] - nums[i-1] > space {
                count = 1;
            } else {
                count += 1;
            }
            max = std::cmp::max(max, count);
        }
        max
    }
}