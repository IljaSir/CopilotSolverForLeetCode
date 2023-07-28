impl Solution {
    pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for (i, v) in nums.iter().enumerate() {
            if let Some(j) = map.get(v) {
                if (i as i32 - j) <= k {
                    return true;
                }
            }
            map.insert(v, i as i32);
        }
        false
    }
}