impl Solution {
    pub fn divide_string(s: String, k: i32, fill: char) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut i = 0;
        let mut j = k as usize;
        let mut s = s;
        while j <= s.len() {
            let mut ss = s[i..j].to_string();
            i += k as usize;
            j += k as usize;
            res.push(ss);
        }
        if i < s.len() {
            let mut ss = s[i..].to_string();
            while ss.len() < k as usize {
                ss.push(fill);
            }
            res.push(ss);
        }
        res
    }
}