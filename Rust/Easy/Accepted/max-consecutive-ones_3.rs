impl Solution {
    pub fn find_max_consecutive_ones(nums: Vec<i32>) -> i32 {
        
        let mut result = 0;
        let mut count = 0;
        for i in 0..nums.len() {
            if nums[i] == 1 {
                count += 1;
            } else {
                result = std::cmp::max(result, count);
                count = 0;
            }
        }
        result = std::cmp::max(result, count);
        result
    }
}