impl Solution {
    pub fn largest_perimeter(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = nums.len() - 1;
        while i >= 2 {
            if nums[i-1] + nums[i-2] > nums[i] {
                return nums[i] + nums[i-1] + nums[i-2];
            }
            i -= 1;
        }
        0
    }
}