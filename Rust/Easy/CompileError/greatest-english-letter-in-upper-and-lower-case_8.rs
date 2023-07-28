impl Solution {
    pub fn greatest_letter(s: String) -> String {
        
        let mut s = s.as_bytes();
        s.sort();
        let mut it = s.iter();
        let mut prev = it.next();
        for c in it {
            if let Some(prev) = prev {
                if (prev.is_ascii_lowercase() && c.is_ascii_uppercase() && prev.to_ascii_uppercase() == *c) || (prev.is_ascii_uppercase() && c.is_ascii_lowercase() && prev.to_ascii_lowercase() == *c) {
                    return String::from_utf8(vec![*c]).unwrap();
                }
            }
            prev = Some(c);
        }
        "".to_string()
    }
}