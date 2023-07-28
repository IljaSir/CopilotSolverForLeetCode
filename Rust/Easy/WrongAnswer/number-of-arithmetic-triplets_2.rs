impl Solution {
    pub fn arithmetic_triplets(nums: Vec<i32>, diff: i32) -> i32 {
        
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        for i in (2..nums.len()).rev() {
            for j in 0..i {
                if nums[i] - nums[j] == diff {
                    *map.entry((j, nums[i])).or_insert(0) += 1;
                }
            }
            if let Some(v) = map.get(&(i, nums[i] + diff)) {
                res += v;
            }
        }
        res
    }
}