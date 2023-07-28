impl Solution {
    pub fn min_subarray(nums: Vec<i32>, p: i32) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        for i in 0..n {
            sum += nums[i] as i64;
        }
        let mut res = n as i32;
        let mut map = std::collections::HashMap::new();
        map.insert(0, -1);
        let mut cur = 0;
        for i in 0..n {
            cur += nums[i] as i64;
            let target = (cur - sum % p as i64 + p as i64) % p as i64;
            if let Some(&j) = map.get(&(target as i32)) {
                res = std::cmp::min(res, (i as i32 - j) as i32);
            }
            map.insert(cur as i32, i as i32);
        }
        if res == n as i32 {
            -1
        } else {
            res
        }
    }
}