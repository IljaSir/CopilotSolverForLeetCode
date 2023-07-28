impl Solution {
    pub fn count_vowels(word: String) -> i64 {
        
        let mut vowels = 0;
        let mut result = 0;
        for c in word.chars() {
            if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                vowels += 1;
            }
            result += vowels;
        }
        result
    }
}