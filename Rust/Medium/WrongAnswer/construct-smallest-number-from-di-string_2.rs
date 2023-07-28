impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut res = String::new();
        let mut min = 1;
        let mut max = pattern.len() as i32 + 1;
        for ch in pattern.chars() {
            if ch == 'I' {
                res.push_str(&min.to_string());
                min += 1;
            } else {
                res.push_str(&max.to_string());
                max -= 1;
            }
        }
        res.push_str(&max.to_string());
        res
    }
}