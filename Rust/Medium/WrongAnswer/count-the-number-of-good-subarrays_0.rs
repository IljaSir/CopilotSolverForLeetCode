impl Solution {
    pub fn count_good(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut sum = 0;
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, 1);
        for i in 0..nums.len() {
            sum += nums[i];
            if let Some(v) = map.get(&(sum - k)) {
                res += v;
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        res
    }
}