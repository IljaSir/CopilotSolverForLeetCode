impl Solution {
    pub fn make_good(s: String) -> String {
        
        let mut res = String::new();
        for c in s.chars() {
            if let Some(&x) = res.as_bytes().last() {
                if (x as i32 - c as i32).abs() == 32 {
                    res.pop();
                    continue;
                }
            }
            res.push(c);
        }
        res
    }
}