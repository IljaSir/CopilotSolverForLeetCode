impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let s = s.as_bytes();
        let n = s.len();
        let mut kmp = vec![0; n];
        for i in 1..n {
            let mut j = kmp[i - 1];
            while j > 0 && s[i] != s[j] {
                j = kmp[j - 1];
            }
            if s[i] == s[j] {
                j += 1;
            }
            kmp[i] = j;
        }
        String::from_utf8(s[..kmp[n - 1]].to_vec()).unwrap()
    }
}