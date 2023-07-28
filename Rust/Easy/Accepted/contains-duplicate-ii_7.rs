impl Solution {
    pub fn contains_nearby_duplicate(nums: Vec<i32>, k: i32) -> bool {
        
        let mut map = std::collections::HashMap::new();
        let mut i = 0;
        for num in nums {
            if let Some(j) = map.get(&num) {
                if i - j <= k {
                    return true;
                }
            }
            map.insert(num, i);
            i += 1;
        }
        false
    }
}