impl Solution {
    pub fn subarrays_div_by_k(nums: Vec<i32>, k: i32) -> i32 {
        
        let mut sum = 0i32;
        let mut map = std::collections::HashMap::<i32, i32>::new();
        map.insert(0, 1);
        let mut count = 0i32;
        for num in nums {
            sum += num;
            let key = sum % k;
            if let Some(v) = map.get(&key) {
                count += v;
                map.insert(key, v+1);
            } else {
                map.insert(key, 1);
            }
        }
        count
    }
}