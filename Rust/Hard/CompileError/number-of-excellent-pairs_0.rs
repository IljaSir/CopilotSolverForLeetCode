impl Solution {
    pub fn count_excellent_pairs(nums: Vec<i32>, k: i32) -> i64 {
        
        let mut ans = 0;
        let mut cnt = vec![0; 60];
        for &num in &nums {
            for i in 0..60 {
                if num & (1 << i) != 0 {
                    cnt[i] += 1;
                }
            }
        }
        for &num in &nums {
            let mut sum = 0;
            for i in 0..60 {
                if num & (1 << i) != 0 {
                    sum += cnt[i];
                } else {
                    sum += nums.len() - cnt[i];
                }
            }
            if sum >= k {
                ans += 1;
            }
        }
        ans
    }
}