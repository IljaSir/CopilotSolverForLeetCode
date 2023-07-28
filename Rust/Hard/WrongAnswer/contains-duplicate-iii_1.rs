impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let mut buckets = std::collections::BTreeMap::new();
        let index_diff = index_diff as usize;
        let value_diff = value_diff as i64;
        for (i, &num) in nums.iter().enumerate() {
            let bucket = num as i64 / (value_diff + 1);
            if buckets.contains_key(&bucket) {
                return true;
            }
            if let Some(&v) = buckets.get(&(bucket - 1)) {
                if num as i64 - v <= value_diff {
                    return true;
                }
            }
            if let Some(&v) = buckets.get(&(bucket + 1)) {
                if v - num as i64 <= value_diff {
                    return true;
                }
            }
            buckets.insert(bucket, num as i64);
            if i >= index_diff {
                buckets.remove(&(nums[i - index_diff] as i64 / (value_diff + 1)));
            }
        }
        false
    }
}