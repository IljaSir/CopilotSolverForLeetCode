impl Solution {
    pub fn smallest_subsequence(s: String, k: i32, letter: char, repetition: i32) -> String {
        
        let mut k = k;
        let mut repetition = repetition;
        let mut stack: Vec<char> = Vec::new();
        let mut count = 0;
        for c in s.chars() {
            if c == letter {
                count += 1;
            }
            while !stack.is_empty() && stack[stack.len() - 1] > c && (stack.len() - 1 + s.len() - c as usize) as i32 >= k {
                if stack[stack.len() - 1] == letter {
                    count -= 1;
                }
                stack.pop();
            }
            if stack.len() < k as usize {
                stack.push(c);
            }
        }
        let mut res = String::new();
        for c in stack {
            if c == letter {
                repetition -= 1;
            }
            if repetition == 0 {
                break;
            }
            res.push(c);
        }
        res
    }
}