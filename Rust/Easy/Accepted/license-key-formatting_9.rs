impl Solution {
    pub fn license_key_formatting(s: String, k: i32) -> String {
        
        let mut s = s.chars().rev().collect::<String>();
        let mut ans = String::new();
        let mut i = 0;
        for c in s.chars() {
            if c == '-' {
                continue;
            }
            if i == k {
                ans.push('-');
                i = 0;
            }
            ans.push(c.to_ascii_uppercase());
            i += 1;
        }
        ans.chars().rev().collect::<String>()
    }
}