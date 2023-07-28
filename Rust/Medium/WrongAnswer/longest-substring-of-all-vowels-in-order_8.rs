impl Solution {
    pub fn longest_beautiful_substring(word: String) -> i32 {
        
        let mut count = 0;
        let mut max = 0;
        let mut prev = 'a';
        let mut found = false;
        let mut last = 'a';
        for c in word.chars() {
            if c < prev {
                count = 0;
                found = false;
            }
            if c == last {
                count += 1;
            } else if c == prev {
                count += 1;
            } else {
                if c == 'a' {
                    if found {
                        max = max.max(count);
                    }
                    found = false;
                    count = 1;
                } else if c == 'e' || c == 'i' || c == 'o' || c == 'u' {
                    if c == 'e' {
                        if count > 0 {
                            found = true;
                        }
                    }
                    count += 1;
                } else {
                    count = 0;
                    found = false;
                }
            }
            last = c;
            prev = c;
        }
        if found {
            max = max.max(count);
        }
        max
    }
}