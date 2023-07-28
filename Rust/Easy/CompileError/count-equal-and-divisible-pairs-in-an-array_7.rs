impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        for (i, x) in nums.iter().enumerate() {
            for (j, y) in nums.iter().enumerate() {
                if i < j && x == y && (i as i32 * j as i32) % k == 0 {
                    count += 1;
                }
            }
        }
        count
    }
}