impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let mut index_diff = index_diff as usize;
        let mut value_diff = value_diff as i64;
        let mut set = std::collections::BTreeSet::new();
        for i in 0..nums.len() {
            if i > index_diff {
                set.remove(&nums[i - index_diff - 1]);
            }
            let n = nums[i] as i64;
            let floor = set.range(n-value_diff..).next();
            if let Some(&m) = floor {
                if m - n <= value_diff {
                    return true;
                }
            }
            let ceil = set.range(..=n+value_diff).next_back();
            if let Some(&m) = ceil {
                if n - m <= value_diff {
                    return true;
                }
            }
            set.insert(n);
        }
        false
    }
}