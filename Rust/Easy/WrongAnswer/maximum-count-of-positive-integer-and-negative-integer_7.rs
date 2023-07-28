impl Solution {
    pub fn maximum_count(nums: Vec<i32>) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        for i in 0..nums.len() {
            if nums[i] >= 0 {
                count += 1;
            } else {
                max = std::cmp::max(count, max);
                count = 0;
            }
        }
        std::cmp::max(count, max)
    }
}