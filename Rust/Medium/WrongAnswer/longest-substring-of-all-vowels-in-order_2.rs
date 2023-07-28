impl Solution {
    pub fn longest_beautiful_substring(word: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut last = 'a';
        for c in word.chars() {
            if c < last {
                count = 0;
            }
            if c != last {
                last = c;
                count = 1;
            } else {
                count += 1;
            }
            if c == 'u' {
                max = max.max(count);
            }
        }
        max as i32
    }
}