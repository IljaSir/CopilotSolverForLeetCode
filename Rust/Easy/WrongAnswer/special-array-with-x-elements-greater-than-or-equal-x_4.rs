impl Solution {
    pub fn special_array(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        for i in 0..nums.len() {
            if nums[i] >= (nums.len() - i) as i32 {
                if i == 0 || nums[i] > nums[i - 1] {
                    return (nums.len() - i) as i32;
                }
            }
        }
        -1
    }
}