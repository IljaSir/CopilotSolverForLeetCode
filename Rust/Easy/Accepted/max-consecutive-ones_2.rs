impl Solution {
    pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
        
        let mut max = 0;
        let mut cur = 0;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                cur += 1;
            } else {
                if cur > max {
                    max = cur;
                }
                cur = 0;
            }
        }
        if cur > max {
            max = cur;
        }
        max
    }
}