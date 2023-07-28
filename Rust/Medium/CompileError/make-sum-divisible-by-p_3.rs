impl Solution {
    pub fn min_subarray(nums: Vec<i32>, p: i32) -> i32 {
        
        let mut sum = 0;
        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        for (i, &n) in nums.iter().enumerate() {
            sum = (sum + n) % p;
            map.insert(sum, i as i32);
        }
        let mut res = nums.len() as i32;
        sum = 0;
        for (i, &n) in nums.iter().enumerate() {
            sum = (sum + n) % p;
            map.remove(&sum);
            if let Some(&j) = map.get(&(p - sum) % p) {
                res = std::cmp::min(res, j - i as i32);
            }
        }
        if res < nums.len() as i32 {res} else {-1}
    }
}