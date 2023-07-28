impl Solution {
    pub fn count_bad_pairs(nums: Vec<i32>) -> i64 {
        
        let mut sum = 0;
        let mut i = 0;
        while i < nums.len() {
            let mut j = i + 1;
            while j < nums.len() {
                if (j as i32 - i as i32) != nums[j] - nums[i] {
                    sum += 1;
                }
                j += 1;
            }
            i += 1;
        }
        sum
    }
}