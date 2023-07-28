impl Solution {
    pub fn license_key_formatting(s: String, k: i32) -> String {
        
        let mut r = String::new();
        let mut i = 0;
        for c in s.chars().rev() {
            if c == '-' {
                continue;
            }
            if i == k {
                r.push('-');
                i = 0;
            }
            r.push(c.to_ascii_uppercase());
            i += 1;
        }
        r.chars().rev().collect()
    }
}