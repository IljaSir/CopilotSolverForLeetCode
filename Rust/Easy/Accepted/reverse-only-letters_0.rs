impl Solution {
    pub fn reverse_only_letters(s: String) -> String {
        
        let mut chars: Vec<char> = s.chars().collect();
        let mut i = 0;
        let mut j = chars.len() - 1;
        while i < j {
            if !chars[i].is_ascii_alphabetic() {
                i += 1;
            } else if !chars[j].is_ascii_alphabetic() {
                j -= 1;
            } else {
                chars.swap(i, j);
                i += 1;
                j -= 1;
            }
        }
        chars.iter().collect()
    }
}