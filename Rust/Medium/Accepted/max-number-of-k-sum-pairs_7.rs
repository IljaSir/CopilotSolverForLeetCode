impl Solution {
    pub fn max_operations(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut ans = 0;
        for n in nums {
            if let Some(v) = map.get_mut(&(k-n)) {
                if *v > 0 {
                    *v -= 1;
                    ans += 1;
                    continue;
                }
            }
            *map.entry(n).or_insert(0) += 1;
        }
        ans
    }
}