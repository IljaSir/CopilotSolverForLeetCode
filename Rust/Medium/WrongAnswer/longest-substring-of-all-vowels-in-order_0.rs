impl Solution {
    pub fn longest_beautiful_substring(word: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut prev = 'a';
        for c in word.chars() {
            if c < prev {
                count = 0;
            }
            count += 1;
            if c == 'u' {
                max = max.max(count);
            }
            prev = c;
        }
        max
    }
}