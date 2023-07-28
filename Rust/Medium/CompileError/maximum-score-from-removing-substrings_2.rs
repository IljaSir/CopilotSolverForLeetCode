impl Solution {
    pub fn maximum_gain(s: String, x: i32, y: i32) -> i32 {
        
        let (x, y) = (x.max(y), x.min(y));
        let (a, b) = if x == x.max(y) { ("ab", "ba") } else { ("ba", "ab") };
        let mut stack = Vec::new();
        let mut score = 0;
        for c in s.chars() {
            stack.push(c);
            if stack.len() >= 2 && &stack[stack.len()-2..] == a.chars().collect::<Vec<_>>().as_slice() {
                stack.pop();
                stack.pop();
                score += x;
            }
        }
        let mut stack = Vec::new();
        for c in stack.iter().rev().map(|x| *x) {
            stack.push(c);
            if stack.len() >= 2 && &stack[stack.len()-2..] == b.chars().collect::<Vec<_>>().as_slice() {
                stack.pop();
                stack.pop();
                score += y;
            }
        }
        score
    }
}