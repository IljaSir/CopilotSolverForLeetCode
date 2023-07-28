impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        let mut cnt = [0; 26];
        for c in s.chars() {
            cnt[c as usize - 'a' as usize] += 1;
        }
        let mut cnt = cnt.iter().filter(|&x| *x > 0).collect::<Vec<_>>();
        cnt.sort_unstable_by(|a, b| b.cmp(a));
        let mut ans = 0;
        for i in 1..cnt.len() {
            if cnt[i] >= cnt[i - 1] {
                ans += cnt[i] - cnt[i - 1] + 1;
                cnt[i] = cnt[i - 1] - 1;
                if cnt[i] == 0 {
                    cnt[i] = 1;
                }
            }
        }
        ans
    }
}