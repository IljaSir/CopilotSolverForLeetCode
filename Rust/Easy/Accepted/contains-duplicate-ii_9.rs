impl Solution {
    pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for (i, n) in nums.iter().enumerate() {
            match map.get(n) {
                Some(j) => {
                    if (i as i32 - *j) <= k {
                        return true;
                    }
                }
                None => {}
            }
            map.insert(n, i as i32);
        }
        false
    }
}