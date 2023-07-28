impl Solution {
    pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for (i, &num) in nums.iter().enumerate() {
            if let Some(&old_i) = map.get(&num) {
                if i as i32 - old_i <= k {
                    return true;
                }
            }
            map.insert(num, i as i32);
        }
        false
    }
}