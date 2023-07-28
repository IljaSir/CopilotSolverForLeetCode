impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut next = vec![0; n];
        next[0] = -1;
        let mut k = -1;
        for i in 1..n {
            while k > -1 && s[(k + 1) as usize] != s[i] {
                k = next[k as usize];
            }
            if s[(k + 1) as usize] == s[i] {
                k += 1;
            }
            next[i] = k;
        }
        next[n - 1] != -1 && (n as i32) % (n as i32 - next[n - 1] - 1) == 0
    }
}