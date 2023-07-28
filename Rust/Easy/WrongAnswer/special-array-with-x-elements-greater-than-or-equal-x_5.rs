impl Solution {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            if nums[i] >= nums.len() as i32 - i as i32 {
                if i == 0 || nums[i] > nums[i - 1] {
                    return nums.len() as i32 - i as i32;
                }
            }
            i += 1;
        }
        -1
    }
}