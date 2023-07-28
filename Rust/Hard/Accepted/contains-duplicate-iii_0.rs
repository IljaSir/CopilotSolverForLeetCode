impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let index_diff = index_diff as usize;
        let value_diff = value_diff as i64;
        let mut set = std::collections::BTreeSet::new();
        for i in 0..nums.len() {
            let n = nums[i] as i64;
            if let Some(&x) = set.range(n - value_diff..=n + value_diff).next() {
                return true;
            }
            set.insert(n);
            if i >= index_diff {
                set.remove(&(nums[i - index_diff] as i64));
            }
        }
        false
    }
}