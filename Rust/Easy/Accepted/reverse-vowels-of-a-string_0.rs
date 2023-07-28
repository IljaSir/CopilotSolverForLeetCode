impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        
        let mut chars: Vec<char> = s.chars().collect();
        let vowels: Vec<char> = vec!['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
        let mut left: usize = 0;
        let mut right: usize = chars.len() - 1;
        while left < right {
            let left_char = chars[left];
            let right_char = chars[right];
            if vowels.contains(&left_char) && vowels.contains(&right_char) {
                chars[left] = right_char;
                chars[right] = left_char;
                left += 1;
                right -= 1;
            } else if vowels.contains(&left_char) {
                right -= 1;
            } else if vowels.contains(&right_char) {
                left += 1;
            } else {
                left += 1;
                right -= 1;
            }
        }
        chars.iter().collect()
    }
}