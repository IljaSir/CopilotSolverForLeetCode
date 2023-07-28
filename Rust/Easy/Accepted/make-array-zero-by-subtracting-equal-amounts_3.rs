impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        let mut count = 0;
        let mut i = 0;
        while i < nums.len() {
            if nums[i] == 0 {
                i += 1;
                continue;
            }
            let mut min = nums[i];
            for j in i..nums.len() {
                if nums[j] < min && nums[j] != 0 {
                    min = nums[j];
                }
            }
            for j in i..nums.len() {
                if nums[j] != 0 {
                    nums[j] -= min;
                }
            }
            count += 1;
        }
        count
    }
}