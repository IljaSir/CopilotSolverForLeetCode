impl Solution {
    pub fn query_string(s: String, n: i32) -> bool {
        
        let s = s.as_bytes();
        let mut i = 1;
        while i <= n {
            let mut j = 0;
            let mut k = i;
            while k > 0 {
                j += 1;
                k >>= 1;
            }
            let mut k = i;
            let mut l = j;
            while l > 0 {
                l -= 1;
                if s[s.len() - j + l] != (k % 2 + 48) as u8 {
                    return false;
                }
                k >>= 1;
            }
            i += 1;
        }
        true
    }
}