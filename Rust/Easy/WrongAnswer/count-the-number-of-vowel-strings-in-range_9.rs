impl Solution {
    pub fn vowel_strings(words: Vec<String>, left: i32, right: i32) -> i32 {
        
        let mut count = 0;
        for word in &words {
            let mut vowel_count = 0;
            let mut has_vowel = false;
            for ch in word.chars() {
                if ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' {
                    vowel_count += 1;
                    has_vowel = true;
                }
            }
            if has_vowel && vowel_count >= left as usize && vowel_count <= right as usize {
                count += 1;
            }
        }
        count
    }
}