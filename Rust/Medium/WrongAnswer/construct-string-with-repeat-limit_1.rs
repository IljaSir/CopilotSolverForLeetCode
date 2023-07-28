impl Solution {
    pub fn repeat_limited_string(s: String, repeat_limit: i32) -> String {
        
        let mut res = String::new();
        let mut count = 0;
        let mut last = ' ';
        for c in s.chars() {
            if c == last {
                count += 1;
            } else {
                count = 1;
                last = c;
            }
            if count <= repeat_limit {
                res.push(c);
            }
        }
        res
    }
}