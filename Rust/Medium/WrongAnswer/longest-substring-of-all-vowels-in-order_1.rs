impl Solution {
    pub fn longest_beautiful_substring(word: String) -> i32 {
        
        let mut max = 0;
        let mut count = 1;
        let mut prev = word.chars().nth(0).unwrap();
        for c in word.chars().skip(1) {
            if c < prev {
                if count == 5 {
                    max = std::cmp::max(max, count);
                }
                count = 1;
            } else if c == prev {
                count += 1;
            } else if c > prev {
                if prev == 'a' {
                    count += 1;
                } else if prev == 'e' {
                    count += 1;
                } else if prev == 'i' {
                    count += 1;
                } else if prev == 'o' {
                    count += 1;
                } else if prev == 'u' {
                    count += 1;
                }
            }
            prev = c;
        }
        if count == 5 {
            max = std::cmp::max(max, count);
        }
        max
    }
}