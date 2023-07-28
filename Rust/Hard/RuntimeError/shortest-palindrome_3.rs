impl Solution {
    pub fn shortest_palindrome(s: String) -> String {
        
        let n = s.len();
        let mut s = s.as_bytes();
        let mut rev = s.to_vec();
        rev.reverse();
        let mut f = vec![0; n + 1];
        for i in 1..=n {
            let mut j = f[i];
            while j > 0 && s[i - 1] != rev[j] {
                j = f[j];
            }
            if s[i - 1] == rev[j] {
                j += 1;
            }
            f[i + 1] = j;
        }
        let mut res = rev[..n - f[n]].to_vec();
        res.extend_from_slice(s);
        String::from_utf8(res).unwrap()
    }
}