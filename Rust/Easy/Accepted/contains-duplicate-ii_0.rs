impl Solution {
    pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
        
        let mut set = std::collections::HashSet::new();
        for i in 0..nums.len() {
            if i > k as usize {
                set.remove(&nums[i - k as usize - 1]);
            }
            if !set.insert(nums[i]) {
                return true;
            }
        }
        false
    }
}