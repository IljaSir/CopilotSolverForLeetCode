impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let mut set = std::collections::BTreeSet::new();
        for (i, &num) in nums.iter().enumerate() {
            let num = num as i64;
            let left = num - value_diff as i64;
            let right = num + value_diff as i64;
            if let Some(&x) = set.range(left..=right).next() {
                if (x - num).abs() <= value_diff as i64 {
                    return true;
                }
            }
            set.insert(num);
            if set.len() > index_diff as usize {
                set.remove(&(nums[i - index_diff as usize] as i64));
            }
        }
        false
    }
}