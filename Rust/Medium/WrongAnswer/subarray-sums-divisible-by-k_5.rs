impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = vec![0; nums.len() + 1];
        for i in 0..nums.len() {
            sum[i + 1] = sum[i] + nums[i];
        }
        let mut map = std::collections::HashMap::new();
        for i in 0..sum.len() {
            let s = sum[i] % k;
            *map.entry(s).or_insert(0) += 1;
        }
        let mut ans = 0;
        for v in map.values() {
            ans += v * (v - 1) / 2;
        }
        ans
    }
}