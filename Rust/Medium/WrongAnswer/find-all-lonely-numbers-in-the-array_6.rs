impl Solution {
    pub fn find_lonely(nums: Vec<i32>) -> Vec<i32> {
        
        let mut lonely_nums = Vec::new();
        for i in 0..nums.len() {
            if i == 0 && nums[i] != nums[i + 1] {
                lonely_nums.push(nums[i]);
            } else if i == nums.len() - 1 && nums[i] != nums[i - 1] {
                lonely_nums.push(nums[i]);
            } else if nums[i] != nums[i - 1] && nums[i] != nums[i + 1] {
                lonely_nums.push(nums[i]);
            }
        }
        return lonely_nums;
    }
}