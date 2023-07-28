impl Solution {
    pub fn num_friend_requests(ages: Vec<i32>) -> i32 {
        
        let mut cnt = vec![0; 121];
        for &age in &ages {
            cnt[age as usize] += 1;
        }
        let mut sum = vec![0; 121];
        for i in 1..121 {
            sum[i] = sum[i - 1] + cnt[i];
        }
        let mut ans = 0;
        for i in 1..121 {
            if cnt[i] == 0 {
                continue;
            }
            let l = (i as f64 * 0.5 + 7.0).ceil() as i32;
            let r = i;
            ans += cnt[i] * (sum[r] - sum[l]) - cnt[i];
        }
        ans
    }
}