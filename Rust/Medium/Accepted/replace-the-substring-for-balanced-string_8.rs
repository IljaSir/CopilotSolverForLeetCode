impl Solution {
    pub fn balanced_string(s: String) -> i32 {
        
        let mut cnt = [0; 4];
        let mut res = s.len();
        let s = s.into_bytes();
        for &c in &s {
            cnt[Self::index(c)] += 1;
        }
        let n = s.len();
        let mut l = 0;
        for r in 0..n {
            cnt[Self::index(s[r])] -= 1;
            while l < n && cnt[0] <= n / 4 && cnt[1] <= n / 4 && cnt[2] <= n / 4 && cnt[3] <= n / 4 {
                res = res.min(r - l + 1);
                cnt[Self::index(s[l])] += 1;
                l += 1;
            }
        }
        res as i32
    }
    fn index(c: u8) -> usize {
        match c {
            b'Q' => 0,
            b'W' => 1,
            b'E' => 2,
            _ => 3,
        }
    }
}