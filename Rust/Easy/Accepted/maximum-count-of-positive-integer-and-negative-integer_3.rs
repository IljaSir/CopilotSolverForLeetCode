impl Solution {
    pub fn maximum_count(nums: Vec<i32>) -> i32 {
        
        let mut pos = 0;
        let mut neg = 0;
        let mut max = 0;
        for i in 0..nums.len() {
            if nums[i] > 0 {
                pos += 1;
                neg = 0;
            } else if nums[i] < 0 {
                pos = 0;
                neg += 1;
            } else {
                pos = 0;
                neg = 0;
            }
            max = max.max(pos).max(neg);
        }
        max
    }
}