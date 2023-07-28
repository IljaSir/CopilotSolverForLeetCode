impl Solution {
    pub fn longest_palindrome(s: String) -> i32 {
        
        let mut counts = [0; 52];
        for c in s.chars() {
            let i = if c.is_ascii_lowercase() {
                c as u8 - 'a' as u8
            } else {
                c as u8 - 'A' as u8 + 26
            };
            counts[i as usize] += 1;
        }
        let mut longest = 0;
        let mut has_odd = false;
        for &count in counts.iter() {
            if count % 2 == 0 {
                longest += count;
            } else {
                has_odd = true;
                longest += count - 1;
            }
        }
        if has_odd {
            longest + 1
        } else {
            longest
        }
    }
}