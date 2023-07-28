impl Solution {
    pub fn reorganize_string(s: String) -> String {
        
        let mut chars = s.chars().collect::<Vec<_>>();
        chars.sort_unstable();
        let mut i = 0;
        let mut j = 1;
        while j < chars.len() {
            if chars[i] == chars[j] {
                j += 1;
            } else {
                chars.swap(i + 1, j);
                i += 1;
                j += 1;
            }
        }
        if i * 2 < chars.len() {
            return "".to_string();
        }
        let mut res = String::new();
        let mut i = 0;
        let mut j = chars.len() / 2;
        while i < chars.len() / 2 && j < chars.len() {
            res.push(chars[i]);
            res.push(chars[j]);
            i += 1;
            j += 1;
        }
        if i < chars.len() / 2 {
            res.push(chars[i]);
        }
        res
    }
}