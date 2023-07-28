impl Solution {
    pub fn decode_at_index(s: String, k: i32) -> String {
        
        let k = k as u64;
        let mut len = 0;
        let mut i = 0;
        let mut k = k;
        let s = s.into_bytes();
        for i in 0..s.len() {
            if s[i] >= b'2' {
                len *= s[i] as u64 - b'0' as u64;
            } else {
                len += 1;
            }
            if len >= k {
                break;
            }
        }
        while i < s.len() {
            if s[i] >= b'2' {
                len /= s[i] as u64 - b'0' as u64;
                k %= len;
            } else {
                if k == len || k == 0 {
                    return String::from_utf8(vec![s[i]]).unwrap();
                }
                len -= 1;
            }
            i -= 1;
        }
        unreachable!();
    }
}