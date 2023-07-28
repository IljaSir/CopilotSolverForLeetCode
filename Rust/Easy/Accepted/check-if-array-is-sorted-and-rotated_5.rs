impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        
        let mut last = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] < last {
                count += 1;
            }
            last = nums[i];
        }
        if count == 0 {
            return true;
        }
        if count > 1 {
            return false;
        }
        nums[0] >= nums[nums.len() - 1]
    }
}