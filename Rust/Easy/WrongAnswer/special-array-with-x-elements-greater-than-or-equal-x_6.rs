impl Solution {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i <= nums.len() {
            if i == nums.len() || nums[nums.len() - i - 1] < i as i32 {
                return i as i32;
            }
            i += 1;
        }
        -1
    }
}