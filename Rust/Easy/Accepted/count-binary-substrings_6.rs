impl Solution {
    pub fn count_binary_substrings(s: String) -> i32 {
        
        let mut count = 0;
        let mut last = 0;
        let mut current = 1;
        let mut chars = s.chars();
        let mut prev = chars.next().unwrap();
        for c in chars {
            if c == prev {
                current += 1;
            } else {
                last = current;
                current = 1;
                prev = c;
            }
            if last >= current {
                count += 1;
            }
        }
        count
    }
}