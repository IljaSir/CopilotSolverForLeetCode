impl Solution {
    pub fn count_bad_pairs(nums: Vec<i32>) -> i64 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            for j in 0..nums.len() {
                if i < j && j - i != nums[j] - nums[i] {
                    count += 1;
                }
            }
        }
        count as i64
    }
}