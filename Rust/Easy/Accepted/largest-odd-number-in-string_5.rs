impl Solution {
    pub fn largest_odd_number(num: String) -> String {
        
        let mut chars = num.chars().collect::<Vec<char>>();
        let mut i = chars.len() - 1;
        while i > 0 && chars[i] as i32 % 2 == 0 {
            i -= 1;
        }
        if chars[i] as i32 % 2 == 0 {
            return "".to_string();
        }
        chars[0..i + 1].iter().collect::<String>()
    }
}