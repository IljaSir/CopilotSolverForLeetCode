impl Solution {
    pub fn reorganize_string(s: String) -> String {
        
        let mut chars = s.chars().collect::<Vec<char>>();
        chars.sort_unstable();
        let mut res = String::new();
        let mut i = 1;
        let mut j = 0;
        while i < chars.len() {
            if chars[i] != chars[j] {
                res.push(chars[j]);
                chars[j] = chars[i];
                j += 1;
            }
            i += 1;
        }
        if j == chars.len() - 1 {
            res.push(chars[j]);
        }
        if res.len() == s.len() {
            return res;
        }
        String::new()
    }
}