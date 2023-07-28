impl Solution {
    pub fn license_key_formatting(s: String, k: i32) -> String {
        
        let mut chars = s.chars().rev().filter(|c| *c != '-').collect::<Vec<char>>();
        let mut result = String::new();
        let mut i = 0;
        while i < chars.len() {
            let mut j = 0;
            while j < k && i < chars.len() {
                result.push(chars[i].to_ascii_uppercase());
                i += 1;
                j += 1;
            }
            if i < chars.len() {
                result.push('-');
            }
        }
        result.chars().rev().collect()
    }
}