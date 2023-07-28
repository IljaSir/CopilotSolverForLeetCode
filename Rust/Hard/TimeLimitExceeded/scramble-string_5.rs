impl Solution {
    pub fn is_scramble(s1: String, s2: String) -> bool {
        
        if s1 == s2 {
            return true;
        }
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let mut c1 = [0; 26];
        let mut c2 = [0; 26];
        for i in 0..s1.len() {
            c1[(s1[i] - b'a') as usize] += 1;
            c2[(s2[i] - b'a') as usize] += 1;
        }
        if c1 != c2 {
            return false;
        }
        let n = s1.len();
        for i in 1..n {
            if (Solution::is_scramble(String::from_utf8_lossy(&s1[..i]).to_string(), String::from_utf8_lossy(&s2[..i]).to_string())
                && Solution::is_scramble(String::from_utf8_lossy(&s1[i..]).to_string(), String::from_utf8_lossy(&s2[i..]).to_string()))
                || (Solution::is_scramble(String::from_utf8_lossy(&s1[..i]).to_string(), String::from_utf8_lossy(&s2[n - i..]).to_string())
                    && Solution::is_scramble(String::from_utf8_lossy(&s1[i..]).to_string(), String::from_utf8_lossy(&s2[..n - i]).to_string()))
            {
                return true;
            }
        }
        false
    }
}