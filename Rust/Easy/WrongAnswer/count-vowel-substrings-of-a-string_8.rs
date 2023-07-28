impl Solution {
    pub fn count_vowel_substrings(word: String) -> i32 {
        
        let mut count = 0;
        let mut prev = 0;
        let mut current = 0;
        for c in word.chars() {
            if "aeiou".contains(c) {
                current += 1;
            } else {
                count += (current * (current + 1)) / 2;
                if prev > 0 {
                    count -= (prev * (prev + 1)) / 2;
                }
                prev = current;
                current = 0;
            }
        }
        count += (current * (current + 1)) / 2;
        if prev > 0 {
            count -= (prev * (prev + 1)) / 2;
        }
        count
    }
}