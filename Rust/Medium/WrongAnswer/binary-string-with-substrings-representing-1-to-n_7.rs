impl Solution {
    pub fn query_string(s: String, n: i32) -> bool {
        
        let s = s.as_bytes();
        let mut i = 1;
        while i <= n {
            let mut j = i;
            let mut k = 0;
            while j > 0 {
                if j & 1 == 1 {
                    if k >= s.len() || s[s.len() - 1 - k] != b'1' {
                        return false;
                    }
                } else {
                    if k >= s.len() || s[s.len() - 1 - k] != b'0' {
                        return false;
                    }
                }
                j >>= 1;
                k += 1;
            }
            i += 1;
        }
        true
    }
}