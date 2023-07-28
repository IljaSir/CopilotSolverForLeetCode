impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let s = s.as_bytes();
        let mut ss = s.to_vec();
        ss.reverse();
        let ss = ss.as_slice();
        let mut kmp = vec![0; s.len()];
        let mut j = 0;
        for i in 1..s.len() {
            while j > 0 && s[i] != s[j] {
                j = kmp[j - 1];
            }
            if s[i] == s[j] {
                j += 1;
            }
            kmp[i] = j;
        }
        j = 0;
        for i in 0..ss.len() {
            while j > 0 && ss[i] != s[j] {
                j = kmp[j - 1];
            }
            if ss[i] == s[j] {
                j += 1;
            }
        }
        let mut ans = vec![];
        ans.extend_from_slice(&ss[..ss.len() - j]);
        ans.extend_from_slice(s);
        unsafe { String::from_utf8_unchecked(ans) }
    }
}