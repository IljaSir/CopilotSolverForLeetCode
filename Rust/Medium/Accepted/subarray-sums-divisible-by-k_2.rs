impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut map = std::collections::HashMap::new();
        let mut sum = 0;
        let mut ans = 0;
        map.insert(0, 1);
        for n in nums {
            sum = (sum + n) % k;
            if sum < 0 {
                sum += k;
            }
            if let Some(v) = map.get(&sum) {
                ans += v;
            }
            *map.entry(sum).or_insert(0) += 1;
        }
        ans
    }
}