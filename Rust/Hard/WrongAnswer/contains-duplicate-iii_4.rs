impl Solution {
    pub fn contains_nearby_almost_duplicate(nums: Vec<i32>, index_diff: i32, value_diff: i32) -> bool {
        
        let mut bucket = std::collections::BTreeMap::new();
        let index_diff = index_diff as usize;
        let value_diff = value_diff as i64;
        for (i, &num) in nums.iter().enumerate() {
            let bucket_id = num as i64 / (value_diff + 1);
            if bucket.contains_key(&bucket_id)
                || bucket.contains_key(&(bucket_id - 1)) && num as i64 - bucket[&(bucket_id - 1)] <= value_diff
                || bucket.contains_key(&(bucket_id + 1)) && bucket[&(bucket_id + 1)] - num as i64 <= value_diff
            {
                return true;
            }
            bucket.insert(bucket_id, num as i64);
            if i >= index_diff {
                bucket.remove(&(nums[i - index_diff] as i64 / (value_diff + 1)));
            }
        }
        false
    }
}