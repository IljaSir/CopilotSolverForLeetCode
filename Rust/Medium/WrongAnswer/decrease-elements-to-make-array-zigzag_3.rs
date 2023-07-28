impl Solution {
    pub fn moves_to_make_zigzag(nums: Vec<i32>) -> i32 {
        
        let mut res = 0;
        for i in 0..nums.len() {
            let mut min = std::i32::MAX;
            if i > 0 {
                min = min.min(nums[i - 1]);
            }
            if i + 1 < nums.len() {
                min = min.min(nums[i + 1]);
            }
            if nums[i] >= min {
                res += nums[i] - min + 1;
            }
        }
        res
    }
}