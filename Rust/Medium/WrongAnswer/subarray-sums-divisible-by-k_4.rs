impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, 1);
        for num in nums {
            sum += num;
            let n = sum % k;
            let m = map.entry(n).or_insert(0);
            *m += 1;
        }
        for v in map.values() {
            count += v * (v - 1) / 2;
        }
        count
    }
}