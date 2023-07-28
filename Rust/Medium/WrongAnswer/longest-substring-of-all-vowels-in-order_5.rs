impl Solution {
    pub fn longest_beautiful_substring(word: String) -> i32 {
        
        let mut res = 0;
        let mut count = 0;
        let mut last = 'a';
        for c in word.chars() {
            if c < last {
                count = 0;
            }
            if c == last {
                count += 1;
            }
            if c > last {
                if c == 'a' {
                    res = res.max(count);
                    count = 0;
                }
                count += 1;
            }
            last = c;
        }
        if last == 'u' {
            res = res.max(count);
        }
        res
    }
}