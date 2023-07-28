impl Solution {
    pub fn repeated_substring_pattern(s: String) -> bool {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut f = vec![0; n + 1];
        for i in 2..=n {
            let mut j = f[i - 1];
            while j > 0 && s[i - 1] != s[j] {
                j = f[j];
            }
            if s[i - 1] == s[j] {
                j += 1;
            }
            f[i] = j;
        }
        f[n] > 0 && n % (n - f[n]) == 0
    }
}