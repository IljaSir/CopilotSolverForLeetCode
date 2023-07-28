impl Solution {
    pub fn smallest_subsequence(s: String, k: i32, letter: char, repetition: i32) -> String {
        
        let s = s.as_bytes();
        let mut stack: Vec<u8> = Vec::new();
        let mut k = k as usize;
        let mut repetition = repetition as usize;
        let mut letter_cnt = 0;
        for i in 0..s.len() {
            while !stack.is_empty() && stack[stack.len() - 1] > s[i] && (stack.len() - 1 + s.len() - i >= k) {
                if stack[stack.len() - 1] == letter as u8 {
                    letter_cnt -= 1;
                }
                stack.pop();
            }
            if s[i] == letter as u8 {
                letter_cnt += 1;
            }
            if letter_cnt >= repetition {
                stack.push(s[i]);
            }
        }
        unsafe { String::from_utf8_unchecked(stack) }
    }
}