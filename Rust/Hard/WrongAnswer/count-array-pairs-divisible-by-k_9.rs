impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut count = 0;
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            let v = nums[i] % k;
            if v == 0 {
                count += map.get(&v).unwrap_or(&0);
            } else {
                count += map.get(&(k - v)).unwrap_or(&0);
            }
            *map.entry(v).or_insert(0) += 1;
        }
        res += count;
        res
    }
}