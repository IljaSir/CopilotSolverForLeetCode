impl Solution {
    pub fn count_vowels(word: String) -> i64 {
        
        let mut sum = 0;
        let mut num = 0;
        for c in word.chars() {
            if c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                num += 1;
            }
            sum += num;
        }
        sum
    }
}