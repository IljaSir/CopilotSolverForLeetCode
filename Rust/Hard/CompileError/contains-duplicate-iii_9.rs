impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let mut map = std::collections::BTreeMap::new();
        for (i, &num) in nums.iter().enumerate() {
            let mut range = map.range(num - value_diff..=num + value_diff);
            if let Some(&(&n, &j)) = range.next() {
                if (i as i32 - j as i32).abs() <= index_diff {
                    return true;
                }
            }
            if let Some(&(&n, &j)) = range.next() {
                if (i as i32 - j as i32).abs() <= index_diff {
                    return true;
                }
            }
            map.insert(num, i);
        }
        false
    }
}