impl Solution {
    pub fn max_vowels(s: String, k: i32) -> i32 {
        
        let k = k as usize;
        let mut max = 0;
        let mut count = 0;
        let mut i = 0;
        let mut j = 0;
        let mut chars = s.chars();
        while j < k {
            let c = chars.next().unwrap();
            if Self::is_vowel(c) {
                count += 1;
            }
            j += 1;
        }
        max = count;
        while let Some(c) = chars.next() {
            if Self::is_vowel(c) {
                count += 1;
            }
            if Self::is_vowel(s.chars().nth(i).unwrap()) {
                count -= 1;
            }
            i += 1;
            j += 1;
            max = max.max(count);
        }
        max as i32
    }
    fn is_vowel(c: char) -> bool {
        match c {
            'a' | 'e' | 'i' | 'o' | 'u' => true,
            _ => false,
        }
    }
}