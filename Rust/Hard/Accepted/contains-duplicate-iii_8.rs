impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let mut set = std::collections::BTreeSet::new();
        for i in 0..nums.len() {
            let num = nums[i] as i64;
            let floor = set.range(..num).next_back().cloned();
            let ceil = set.range(num..).next().cloned();
            if floor.map_or(false, |x| num - x <= value_diff as i64) ||
                ceil.map_or(false, |x| x - num <= value_diff as i64) {
                return true;
            }
            set.insert(num);
            if i as i32 >= index_diff {
                set.remove(&(nums[i - index_diff as usize] as i64));
            }
        }
        false
    }
}