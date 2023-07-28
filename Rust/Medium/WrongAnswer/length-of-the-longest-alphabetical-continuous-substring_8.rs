impl Solution {
    pub fn longest_continuous_substring(s: String) -> i32 {
        
        let mut max = 0;
        let mut current = 0;
        let mut previous = 0;
        for c in s.chars() {
            let i = c as u8 - 'a' as u8;
            if i > previous {
                current += 1;
            } else {
                max = max.max(current);
                current = 1;
            }
            previous = i;
        }
        max.max(current)
    }
}