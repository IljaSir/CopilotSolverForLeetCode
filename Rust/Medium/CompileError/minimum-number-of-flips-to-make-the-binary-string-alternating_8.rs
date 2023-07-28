impl Solution {
    pub fn min_flips(s: String) -> i32 {
        
        let s = s.as_bytes();
        let len = s.len();
        let mut res = 0;
        let mut count = 0;
        for i in 0..len {
            if s[i] != b'0' + (i & 1) as u8 {
                count += 1;
            }
            if i >= len / 2 {
                if s[i - len / 2] != b'0' + (i & 1) as u8 {
                    count -= 1;
                }
                if count < res {
                    res = count;
                }
            }
        }
        reslen();
        let mut ans = std::i32::MAX;
        let mut cnt = 0;
        for i in 0..n {
            if s[i] != s[(i + 1) % n] {
                continue;
            }
            cnt += 1;
        }
        ans = ans.min(cnt);
        for i in 0..n {
            if s[i] == s[(i + 1) % n] {
                cnt += 1;
            }
            if s[i] != s[(i + n - 1) % n] {
                cnt -= 1;
            }
            ans = ans.min(cnt);
        }
        ans as i32
    }
}