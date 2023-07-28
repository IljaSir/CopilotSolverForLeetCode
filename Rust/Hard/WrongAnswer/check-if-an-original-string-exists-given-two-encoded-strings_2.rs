impl Solution {
    pub fn possibly_equals(s1: String, s2: String) -> bool {
        
        if s1 == s2 {
            return true;
        }
        let s1 = s1.into_bytes();
        let s2 = s2.into_bytes();
        let mut i = 0;
        let mut j = 0;
        let mut n = s1.len();
        let mut m = s2.len();
        while i < n && j < m {
            if s1[i] == s2[j] {
                i += 1;
                j += 1;
                continue;
            }
            if s1[i].is_ascii_digit() && s2[j].is_ascii_digit() {
                let mut k = i;
                while k < n && s1[k].is_ascii_digit() {
                    k += 1;
                }
                let mut l = j;
                while l < m && s2[l].is_ascii_digit() {
                    l += 1;
                }
                if k - i != l - j {
                    return false;
                }
                if k - i == 1 {
                    return false;
                }
                let mut x = s1[i] as i32 - '0' as i32;
                let mut y = s2[j] as i32 - '0' as i32;
                i += 1;
                j += 1;
                while i < k && j < l {
                    x = x * 10 + (s1[i] as i32 - '0' as i32);
                    y = y * 10 + (s2[j] as i32 - '0' as i32);
                    i += 1;
                    j += 1;
                }
                if x != y {
                    return false;
                }
            } else {
                return false;
            }
        }
        i == n && j == m
    }
}