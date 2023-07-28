impl Solution {
    pub fn longest_beautiful_substring(word: String) -> i32 {
        
        let mut cur = ' ';
        let mut start = 0;
        let mut max = 0;
        let mut count = 0;
        for (i, c) in word.chars().enumerate() {
            if c < cur {
                start = i;
                count = 0;
            }
            if c > cur {
                count += 1;
            }
            if count == 5 {
                max = max.max(i - start + 1);
            }
            cur = c;
        }
        max as i32
    }
}