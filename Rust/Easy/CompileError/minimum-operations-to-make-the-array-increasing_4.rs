impl Solution {
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        for i in 1..nums.len() {
            if nums[i] > nums[i - 1] {
                continue;
            }
            count += nums[i - 1] - nums[i] + 1;
            nums[i] = nums[i - 1] + 1;
        }
        count
    }
}