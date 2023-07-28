impl Solution {
    pub fn divide_string(s: String, k: i32, fill: char) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        let mut i = 0;
        let mut j = i + k as usize;
        let mut s = s;
        while j <= s.len() {
            res.push(s[i..j].to_string());
            i = j;
            j = i + k as usize;
        }
        if i < s.len() {
            let mut tmp = s[i..].to_string();
            while tmp.len() < k as usize {
                tmp.push(fill);
            }
            res.push(tmp);
        }
        res
    }
}