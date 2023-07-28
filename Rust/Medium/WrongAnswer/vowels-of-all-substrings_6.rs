impl Solution {
    pub fn count_vowels(word: String) -> i64 {
        
        let mut answer = 0;
        let mut vowels = 0;
        for c in word.chars() {
            if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                vowels += 1;
            }
        }
        for (i, c) in word.chars().enumerate() {
            if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                answer += vowels * (word.len() - i) as i64;
                vowels -= 1;
            }
        }
        answer
    }
}