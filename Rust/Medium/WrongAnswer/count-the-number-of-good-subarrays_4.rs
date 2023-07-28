impl Solution {
    pub fn count_good(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        let mut odd = 0;
        for i in 0..nums.len() {
            if nums[i] % 2 == 1 {
                odd += 1;
            }
            map.entry(odd).and_modify(|v| *v += 1).or_insert(1);
            if odd >= k {
                count += map[&(odd - k)];
            }
        }
        count as i64
    }
}