impl Solution {
    pub fn divide_array(nums: Vec<i32>) -> bool {
        
        let mut nums = nums;
        nums.sort();
        let mut i = 0;
        while i < nums.len() {
            if nums[i] != nums[i + 1] {
                return false;
            }
            i += 2;
        }
        true
    }
}