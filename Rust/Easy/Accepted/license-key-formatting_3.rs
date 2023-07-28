impl Solution {
    pub fn license_key_formatting(s: String, k: i32) -> String {
        
        let mut res = String::new();
        let mut counter = 0;
        for c in s.chars().rev() {
            if c == '-' {
                continue;
            }
            if counter == k {
                res.push('-');
                counter = 0;
            }
            res.push(c.to_ascii_uppercase());
            counter += 1;
        }
        res.chars().rev().collect()
    }
}