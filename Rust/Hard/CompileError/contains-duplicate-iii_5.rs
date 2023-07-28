impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let index_diff = index_diff as usize;
        let value_diff = value_diff as i64;
        let mut set = std::collections::BTreeSet::new();
        for i in nums.iter().enumerate() {
            let (index, &num) = i;
            if set.range((num - value_diff)..=(num + value_diff)).next().is_some() {
                return true;
            }
            set.insert(num);
            if set.len() > index_diff {
                set.remove(&nums[index - index_diff]);
            }
        }
        false
    }
}