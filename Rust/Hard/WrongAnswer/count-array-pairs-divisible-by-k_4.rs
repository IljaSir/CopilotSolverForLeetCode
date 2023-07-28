impl Solution {
    pub fn count_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut res = 0;
        let mut cnt = vec![0; k as usize];
        for n in nums {
            let n = n % k;
            if n == 0 {
                res += cnt[0];
            } else if 2 * n == k {
                res += cnt[n as usize];
            } else {
                res += cnt[(k - n) as usize];
            }
            cnt[n as usize] += 1;
        }
        res
    }
}