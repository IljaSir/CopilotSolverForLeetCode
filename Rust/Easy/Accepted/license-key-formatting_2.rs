impl Solution {
    pub fn license_key_formatting(s: String, k: i32) -> String {
        
        let mut ret = String::new();
        let mut count = 0;
        for c in s.chars().rev() {
            if c == '-' {
                continue;
            }
            if count == k {
                ret.push('-');
                count = 0;
            }
            ret.push(c.to_ascii_uppercase());
            count += 1;
        }
        ret.chars().rev().collect()
    }
}