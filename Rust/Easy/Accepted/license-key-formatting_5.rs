impl Solution {
    pub fn license_key_formatting(s: String, k: i32) -> String {
        
        let mut result = String::new();
        let mut count = 0;
        for c in s.chars().rev() {
            if c != '-' {
                count += 1;
                result.push(if c.is_ascii_alphabetic() { c.to_ascii_uppercase() } else { c });
                if count == k {
                    count = 0;
                    result.push('-');
                }
            }
        }
        if result.ends_with('-') {
            result.pop();
        }
        result.chars().rev().collect()
    }
}