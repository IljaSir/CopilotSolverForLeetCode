impl Solution {
    pub fn reverse_vowels(s: String) -> String {
        
        let mut chars = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = chars.len() - 1;
        while i < j {
            while i < j && !Self::is_vowel(chars[i]) {
                i += 1;
            }
            while i < j && !Self::is_vowel(chars[j]) {
                j -= 1;
            }
            if i < j {
                chars.swap(i, j);
                i += 1;
                j -= 1;
            }
        }
        chars.iter().collect()
    }
    
    fn is_vowel(c: char) -> bool {
        match c {
            'a' | 'e' | 'i' | 'o' | 'u' | 'A' | 'E' | 'I' | 'O' | 'U' => true,
            _ => false,
        }
    }
}