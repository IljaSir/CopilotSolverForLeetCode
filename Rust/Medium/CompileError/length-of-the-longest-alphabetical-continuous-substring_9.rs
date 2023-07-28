impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 0;
        let mut current = 1;
        let mut s = s.chars();
        if let Some(c) = s.next() {
            for c2 in s {
                if c2 as u8 == c as u8 + 1 {
                    current += 1;
                } else {
                    if current > max {
                        max = current;
                    }
                    current = 1;
                }
                if current > max {
                    max = current;
                }
                c = c2;
            }
        }
        max
    }
}