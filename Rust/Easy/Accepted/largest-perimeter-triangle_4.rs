impl Solution {
    pub fn largest_perimeter(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort_unstable();
        for i in (2..nums.len()).rev() {
            if nums[i] < nums[i-1] + nums[i-2] {
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        0
    }
}