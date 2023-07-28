impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let s = s.as_bytes();
        let mut r = s.to_vec();
        r.reverse();
        let mut t = [0; 100_000];
        let mut i = 1;
        let mut j = 0;
        while i < s.len() {
            if s[i] == s[j] {
                t[i] = j + 1;
                i += 1;
                j += 1;
            } else if j > 0 {
                j = t[j - 1];
            } else {
                i += 1;
            }
        }
        let mut i = 0;
        let mut j = 0;
        while i < r.len() {
            if r[i] == s[j] {
                i += 1;
                j += 1;
            } else if j > 0 {
                j = t[j - 1];
            } else {
                i += 1;
            }
        }
        let mut ans = Vec::new();
        ans.extend_from_slice(&r[..r.len() - j]);
        ans.extend_from_slice(s);
        String::from_utf8(ans).unwrap()
    }
}