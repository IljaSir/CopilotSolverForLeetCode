impl Solution {
    pub fn find_error_nums(nums: Vec<i32>) -> Vec<i32> {
        
        let mut nums = nums;
        nums.sort();
        let mut result = vec![0, 0];
        for i in 0..nums.len() - 1 {
            if nums[i] == nums[i + 1] {
                result[0] = nums[i];
            } else if nums[i] + 1 != nums[i + 1] {
                result[1] = nums[i] + 1;
            }
        }
        if result[1] == 0 {
            result[1] = nums[nums.len() - 1] + 1;
        }
        result
    }
}