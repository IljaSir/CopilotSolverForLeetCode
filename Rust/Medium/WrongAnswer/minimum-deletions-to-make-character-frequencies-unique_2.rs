impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        let mut cnt = vec![0; 26];
        for c in s.chars() {
            cnt[c as usize - 'a' as usize] += 1;
        }
        cnt.sort();
        let mut ans = 0;
        for i in 1..26 {
            if cnt[i] > 0 {
                if cnt[i] <= cnt[i - 1] {
                    ans += cnt[i - 1] - cnt[i] + 1;
                    cnt[i] = cnt[i - 1] + 1;
                }
            }
        }
        ans
    }
}