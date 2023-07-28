impl Solution {
    pub fn reformat(s: String) -> String {
        
        let mut chars = s.chars().collect::<Vec<char>>();
        let mut digits = chars.iter().filter(|c| c.is_ascii_digit()).count();
        let mut letters = chars.iter().filter(|c| c.is_ascii_alphabetic()).count();
        if (digits - letters).abs() > 1 {
            return "".to_string();
        }
        if digits > letters {
            chars.sort_by(|a, b| {
                if a.is_ascii_digit() && b.is_ascii_alphabetic() {
                    std::cmp::Ordering::Less
                } else {
                    std::cmp::Ordering::Greater
                }
            });
        } else {
            chars.sort_by(|a, b| {
                if a.is_ascii_alphabetic() && b.is_ascii_digit() {
                    std::cmp::Ordering::Less
                } else {
                    std::cmp::Ordering::Greater
                }
            });
        }
        chars.into_iter().collect()
    }
}