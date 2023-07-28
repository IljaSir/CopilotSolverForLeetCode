impl Solution {
    pub fn first_missing_positive(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == (i + 1) as i32 || nums[i] <= 0 || nums[i] > nums.len() as i32 {
                i += 1;
            } else if nums[(nums[i] - 1) as usize] != nums[i] {
                nums.swap(i, (nums[i] - 1) as usize);
            } else {
                i += 1;
            }
        }
        let mut i = 0;
        while i < nums.len() && nums[i] == (i + 1) as i32 {
            i += 1;
        }
        (i + 1) as i32
    }
}