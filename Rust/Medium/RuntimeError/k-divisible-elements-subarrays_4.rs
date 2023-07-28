impl Solution {
    pub fn count_distinct(nums: Vec<i32>, k: i32, p: i32) -> i32 {
        
        let mut ans = 0;
        let n = nums.len();
        let mut cnt = vec![0; p as usize];
        let mut sum = 0;
        for i in 0..n {
            sum = (sum + nums[i]) % p;
            cnt[sum as usize] += 1;
        }
        for i in 0..p as usize {
            ans += cnt[i] * (cnt[i] - 1) / 2;
        }
        for l in 0..n {
            let mut sum = 0;
            for r in l..n {
                sum = (sum + nums[r]) % p;
                if r - l + 1 > k as usize {
                    sum = (sum + p - nums[l]) % p;
                }
                if r - l + 1 >= k as usize {
                    ans -= cnt[sum as usize];
                    cnt[sum as usize] -= 1;
                }
            }
        }
        ans
    }
}