impl Solution {
    pub fn divide_string(s: String, k: i32, fill: char) -> Vec<String> {
        
        let mut result = Vec::new();
        let mut i = 0;
        let mut j = k as usize;
        let mut s = s;
        while j <= s.len() {
            result.push(s[i..j].to_string());
            i += k as usize;
            j += k as usize;
        }
        if i < s.len() {
            let mut s = s[i..].to_string();
            while s.len() < k as usize {
                s.push(fill);
            }
            result.push(s);
        }
        result
    }
}