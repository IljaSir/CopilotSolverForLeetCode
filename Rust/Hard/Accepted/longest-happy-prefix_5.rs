impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let n = s.len();
        let mut prefix = vec![0; n];
        let mut i = 1;
        let mut j = 0;
        let s = s.as_bytes();
        while i < n {
            if s[i] == s[j] {
                prefix[i] = j + 1;
                i += 1;
                j += 1;
            } else {
                if j != 0 {
                    j = prefix[j - 1];
                } else {
                    prefix[i] = 0;
                    i += 1;
                }
            }
        }
        String::from_utf8(s[..prefix[n - 1]].to_vec()).unwrap()
    }
}