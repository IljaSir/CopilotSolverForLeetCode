impl Solution {
    pub fn count_bad_pairs(nums: Vec<i32>) -> i64 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            for j in i + 1..nums.len() {
                if nums[j] - nums[i] == (j - i) as i32 {
                    count += 1;
                }
            }
        }
        count as i64
    }
}