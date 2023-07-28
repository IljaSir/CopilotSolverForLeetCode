impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        
        let k = k as usize;
        let mut vowels = 0;
        let mut max = 0;
        let mut i = 0;
        let mut j = 0;
        let mut chars = s.chars();
        while j < k {
            let c = chars.next().unwrap();
            if Self::is_vowel(c) {
                vowels += 1;
            }
            j += 1;
        }
        max = vowels;
        while let Some(c) = chars.next() {
            if Self::is_vowel(c) {
                vowels += 1;
            }
            if Self::is_vowel(s.chars().nth(i).unwrap()) {
                vowels -= 1;
            }
            i += 1;
            max = max.max(vowels);
        }
        max
    }
    fn is_vowel(c: char) -> bool {
        match c {
            'a' | 'e' | 'i' | 'o' | 'u' => true,
            _ => false,
        }
    }
}