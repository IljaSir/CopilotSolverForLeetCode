impl Solution {
    pub fn count_vowel_substrings(word: String) -> i32 {
        
        let mut count = 0;
        let mut last = 0;
        let mut last_count = 0;
        for c in word.chars() {
            if c == last {
                last_count += 1;
            } else {
                last = c;
                last_count = 1;
            }
            count += last_count;
        }
        count
    }
}