impl Solution {
    pub fn longest_palindrome(s: String) -> String {
        

        let s = s.as_bytes();
        let mut result = String::new();
        for i in 0..s.len() {
            for j in (i..s.len()).rev() {
                if s[i] == s[j] {
                    let mut flag = true;
                    for k in 0..(j - i + 1) / 2 {
                        if s[i + k] != s[j - k] {
                            flag = false;
                            break;
                        }
                    }
                    if flag && (j - i + 1) > result.len() {
                        result = String::from_utf8_lossy(&s[i..=j]).to_string();
                    }
                }
            }
        }
        result
    }
}