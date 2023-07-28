impl Solution {
    pub fn min_swaps(s: String) -> i32 {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut cnt = [0; 2];
        for i in 0..n {
            cnt[(s[i] - b'0') as usize] += 1;
        }
        if (cnt[0] - cnt[1]).abs() > 1 {
            return -1;
        }
        let mut res = n;
        for i in 0..2 {
            let mut cur = 0;
            for j in 0..n {
                if s[j] != b'0' + ((i + j) & 1) as u8 {
                    cur += 1;
                }
            }
            res = res.min(cur);
        }
        res as i32 / 2
    }
}