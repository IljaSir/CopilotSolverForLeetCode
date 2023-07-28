impl Solution {
    pub fn max_value(n: String, x: i32) -> String {
        
        let mut s = n.clone();
        let x = x.to_string();
        if s.starts_with('-') {
            for (i, c) in s.chars().enumerate() {
                if c > x.chars().next().unwrap() {
                    s.insert(i, x.chars().next().unwrap());
                    return s;
                }
            }
        } else {
            for (i, c) in s.chars().enumerate() {
                if c < x.chars().next().unwrap() {
                    s.insert(i, x.chars().next().unwrap());
                    return s;
                }
            }
        }
        s.push(x.chars().next().unwrap());
        s
    }
}