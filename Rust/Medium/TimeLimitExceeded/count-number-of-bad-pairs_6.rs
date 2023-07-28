impl Solution {
    pub fn count_bad_pairs(nums: Vec<i32>) -> i64 {
        
        let mut count = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                if (j as i64 - i as i64) != (nums[j] as i64 - nums[i] as i64) {
                    count += 1;
                }
            }
        }
        count
    }
}