impl Solution {
    pub fn minimum_operations(nums: Vec<i32>) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut count = 0;
        let mut last = 0;
        for i in 0..nums.len() {
            if nums[i] != 0 && nums[i] != last {
                count += 1;
                last = nums[i];
            }
        }
        count
    }
}