impl Solution {
    pub fn sort_string(s: String) -> String {
        
        let mut s = s.into_bytes();
        s.sort();
        let mut i = 0;
        let mut j = 0;
        let mut res = Vec::new();
        while i < s.len() {
            while j < s.len() && s[j] == s[i] {
                j += 1;
            }
            res.push(s[i]);
            i = j;
        }
        let mut i = res.len() - 2;
        let mut j = res.len() - 2;
        while i > 0 {
            while j > 0 && res[j] == res[i] {
                j -= 1;
            }
            res.push(res[i]);
            i = j;
        }
        String::from_utf8(res).unwrap()
    }
}