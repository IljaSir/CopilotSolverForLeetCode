impl Solution {
    pub fn find_smallest_integer(nums: Vec<i32>, value: i32) -> i32 {
        
        let mut nums = nums;
        nums.sort();
        let mut missing = 0;
        for i in 0..nums.len() {
            if nums[i] > missing {
                if nums[i] - missing > value {
                    return missing;
                } else {
                    value -= nums[i] - missing;
                    missing = nums[i];
                }
            }
            missing += 1;
        }
        missing + value / nums.len() as i32
    }
}