impl Solution {
    pub fn count_distinct(nums: Vec<i32>, k: i32, p: i32) -> i32 {
        
        let n = nums.len();
        let mut res = 0;
        let mut pre = vec![0; n + 1];
        for i in 0..n {
            pre[i + 1] = (pre[i] + nums[i]) % p;
        }
        let mut map = std::collections::HashMap::new();
        for i in 0..=n {
            if i as i32 > k {
                *map.entry(pre[i - k as usize - 1]).or_insert(0) -= 1;
            }
            res += map.entry(pre[i]).or_insert(0);
            *map.entry(pre[i]).or_insert(0) += 1;
        }
        res
    }
}