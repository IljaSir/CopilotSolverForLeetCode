impl Solution {
    pub fn query_string(s: String, n: i32) -> bool {
        
        let n = n as usize;
        let mut v = vec![false; n + 1];
        let mut i = 0;
        let mut j = 1;
        while j <= n {
            if s.as_bytes()[i] == '1' as u8 {
                v[j] = true;
            }
            i += 1;
            j *= 2;
        }
        for i in 1..n + 1 {
            if v[i] {
                let mut j = i;
                let mut k = i;
                while k > 0 {
                    if s.as_bytes()[j] == '0' as u8 {
                        return false;
                    }
                    k /= 2;
                    j += 1;
                }
            }
        }
        true
    }
}