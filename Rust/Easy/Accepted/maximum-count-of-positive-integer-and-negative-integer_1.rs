impl Solution {
    pub fn maximum_count(nums: Vec<i32>) -> i32 {
        
        let mut pos = 0;
        let mut neg = 0;
        let mut max = 0;
        for i in 0..nums.len() {
            if nums[i] > 0 {
                pos += 1;
            }
            if nums[i] < 0 {
                neg += 1;
            }
            if nums[i] == 0 {
                if pos > neg {
                    neg = 0;
                } else {
                    pos = 0;
                }
            }
            if pos > max {
                max = pos;
            }
            if neg > max {
                max = neg;
            }
        }
        max
    }
}