impl Solution {
    pub fn longest_beautiful_substring(word: String) -> i32 {
        
        let mut max = 0;
        let mut count = 0;
        let mut last = 'a';
        for c in word.chars() {
            if c >= last {
                count += 1;
                if c == 'u' {
                    max = std::cmp::max(max, count);
                }
            } else {
                count = 1;
            }
            last = c;
        }
        max as i32
    }
}