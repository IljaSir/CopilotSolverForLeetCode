impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut res = String::new();
        let mut i = 0;
        let mut j = pattern.len() as i32;
        for p in pattern.chars() {
            if p == 'I' {
                res.push_str(&i.to_string());
                i += 1;
            } else {
                res.push_str(&j.to_string());
                j -= 1;
            }
        }
        res.push_str(&(i as i32).to_string());
        res
    }
}