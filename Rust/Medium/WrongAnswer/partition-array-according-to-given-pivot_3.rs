impl Solution {
    pub fn pivot_array(nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        
        let mut nums = nums;
        let mut left = 0;
        let mut right = nums.len() - 1;
        let mut i = 0;
        while i <= right {
            if nums[i] < pivot {
                nums.swap(left, i);
                left += 1;
                i += 1;
            } else if nums[i] > pivot {
                nums.swap(right, i);
                right -= 1;
            } else {
                i += 1;
            }
        }
        nums
    }
}