impl Solution {
    pub fn longest_beautiful_substring(word: String) -> i32 {
        
        let mut c = 0;
        let mut max = 0;
        let mut s = 0;
        for (i, ch) in word.chars().enumerate() {
            if i == 0 || ch == word.chars().nth(i - 1).unwrap() {
                c += 1;
            } else if ch > word.chars().nth(i - 1).unwrap() {
                c += 1;
                s += 1;
            } else {
                c = 1;
                s = 0;
            }
            if s == 4 {
                max = max.max(c);
            }
        }
        max
    }
}