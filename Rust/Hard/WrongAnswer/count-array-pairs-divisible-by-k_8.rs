impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        for i in 0..nums.len() {
            let x = nums[i] % k;
            let y = (k - x) % k;
            if let Some(&v) = map.get(&y) {
                res += v;
            }
            *map.entry(x).or_insert(0) += 1;
        }
        res
    }
}