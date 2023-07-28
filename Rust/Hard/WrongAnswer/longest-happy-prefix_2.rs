impl Solution {
    pub fn longest_prefix(s: String) -> String {
        
        let s = s.as_bytes();
        let mut i = 0;
        let mut j = 1;
        let mut k = 0;
        let mut next = vec![0; s.len()];
        while j < s.len() {
            if s[i] == s[j] {
                i += 1;
                next[j] = i;
                j += 1;
            } else if i > 0 {
                i = next[i-1];
            } else {
                next[j] = 0;
                j += 1;
            }
        }
        let mut ret = String::new();
        let mut i = s.len()-1;
        let mut j = next[i];
        while j > 0 {
            ret.push(s[j-1] as char);
            i = j-1;
            j = next[i];
        }
        ret
    }
}