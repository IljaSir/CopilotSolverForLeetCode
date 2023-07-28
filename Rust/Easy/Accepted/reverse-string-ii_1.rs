impl Solution {
    pub fn reverse_str(s: String, k: i32) -> String {
        
        let k = k as usize;
        let mut res = String::with_capacity(s.len());
        let mut chars = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        while i < chars.len() {
            if i + k <= chars.len() {
                chars[i..i+k].reverse();
                res.extend(chars[i..i+k].iter());
            } else {
                chars[i..].reverse();
                res.extend(chars[i..].iter());
            }
            i += k;
            if i >= chars.len() { break; }
            if i + k <= chars.len() {
                res.extend(chars[i..i+k].iter());
            } else {
                res.extend(chars[i..].iter());
            }
            i += k;
        }
        res
    }
}