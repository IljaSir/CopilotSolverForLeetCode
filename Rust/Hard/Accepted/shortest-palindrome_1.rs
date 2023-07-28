impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let mut s = s.as_bytes().to_vec();
        let mut t = s.clone();
        t.reverse();
        let mut f = vec![0; s.len()];
        for i in 1..s.len() {
            let mut j = f[i - 1];
            while j > 0 && s[i] != s[j] {
                j = f[j - 1];
            }
            f[i] = if s[i] == s[j] { j + 1 } else { 0 };
        }
        let mut j = 0;
        for i in 0..t.len() {
            while j > 0 && s[j] != t[i] {
                j = f[j - 1];
            }
            if s[j] == t[i] {
                j += 1;
            }
        }
        let mut res = vec![0; t.len() + s.len() - j];
        res[..t.len()].copy_from_slice(&t);
        res[t.len()..].copy_from_slice(&s[j..]);
        String::from_utf8(res).unwrap()
    }
}