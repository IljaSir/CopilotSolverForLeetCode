impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, 1);
        let mut res = 0;
        for n in nums {
            sum = (sum + n) % k;
            if sum < 0 {
                sum += k;
            }
            let count = map.entry(sum).or_insert(0);
            *count += 1;
            res += count - 1;
        }
        res
    }
}