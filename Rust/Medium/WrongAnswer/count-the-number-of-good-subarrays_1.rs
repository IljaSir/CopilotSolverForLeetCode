impl Solution {
    pub fn count_good(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut res = 0;
        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        for i in 0..nums.len() {
            sum += nums[i];
            if sum == k {
                res += 1;
            }
            if let Some(&j) = map.get(&(sum - k)) {
                res += j;
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        res
    }
}