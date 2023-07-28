impl Solution {
    pub fn license_key_formatting(s: String, k: i32) -> String {
        
        let mut res = String::new();
        let mut count = 0;
        for c in s.chars().rev() {
            if c != '-' {
                res.push(c.to_ascii_uppercase());
                count += 1;
                if count == k {
                    count = 0;
                    res.push('-');
                }
            }
        }
        if res.ends_with('-') {
            res.pop();
        }
        res.chars().rev().collect()
    }
}