impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0;
        let mut count = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, 1);
        for num in nums {
            sum += num;
            let m = (sum % k + k) % k;
            let c = map.entry(m).or_insert(0);
            count += *c;
            *c += 1;
        }
        count
    }
}