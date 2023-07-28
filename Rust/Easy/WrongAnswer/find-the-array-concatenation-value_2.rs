impl Solution {
    pub fn find_the_array_conc_val(nums: Vec<i32>) -> i64 {
        
        let mut nums = nums;
        let mut result = 0;
        while !nums.is_empty() {
            if nums.len() == 1 {
                result += nums[0] as i64;
                nums.remove(0);
            } else {
                result += (nums[0] * 10 + nums[nums.len() - 1]) as i64;
                nums.remove(0);
                nums.remove(nums.len() - 1);
            }
        }
        result
    }
}