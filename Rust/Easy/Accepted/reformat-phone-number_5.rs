impl Solution {
    pub fn reformat_number(number: String) -> String {
        
        let mut s = number.chars().filter(|&c| c != ' ' && c != '-').collect::<String>();
        let mut result = String::new();
        while s.len() > 4 {
            result.push_str(&s[0..3]);
            result.push('-');
            s = s[3..].to_string();
        }
        if s.len() == 4 {
            result.push_str(&s[0..2]);
            result.push('-');
            result.push_str(&s[2..]);
        } else {
            result.push_str(&s);
        }
        result
    }
}