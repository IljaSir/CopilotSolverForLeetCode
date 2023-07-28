impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            for j in (i + 1)..nums.len() {
                if nums[i] == nums[j] && (i as i32 * j as i32) % k == 0 {
                    count += 1;
                }
            }
        }
        count
    }
}