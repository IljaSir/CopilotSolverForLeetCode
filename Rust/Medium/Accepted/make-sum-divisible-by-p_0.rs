impl Solution {
    pub fn min_subarray(nums: Vec<i32>, p: i32) -> i32 {
        
        let n = nums.len();
        let mut sum = 0;
        for &x in &nums {
            sum = (sum + x) % p;
        }
        if sum == 0 {
            return 0;
        }
        let mut mp = std::collections::HashMap::new();
        mp.insert(0, -1);
        let mut cur = 0;
        let mut res = n as i32;
        for i in 0..n {
            cur = (cur + nums[i]) % p;
            mp.insert(cur, i as i32);
            let want = (cur - sum + p) % p;
            if let Some(&j) = mp.get(&want) {
                res = res.min(i as i32 - j);
            }
        }
        if res < n as i32 {
            res
        } else {
            -1
        }
    }
}