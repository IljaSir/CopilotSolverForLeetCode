impl Solution {
    pub fn maximum_gain(s: String, x: i32, y: i32) -> i32 {
        
        let (x, y) = (x.max(y), x.min(y));
        let (a, b) = if x == x.max(y) { ('a', 'b') } else { ('b', 'a') };
        let mut ans = 0;
        let mut stack = vec![];
        for c in s.chars() {
            if c == b {
                if let Some(&top) = stack.last() {
                    if top == a {
                        stack.pop();
                        ans += x;
                        continue;
                    }
                }
            }
            stack.push(c);
        }
        let mut stack = vec![];
        for c in stack.into_iter().rev() {
            if c == b {
                if let Some(&top) = stack.last() {
                    if top == a {
                        stack.pop();
                        ans += y;
                        continue;
                    }
                }
            }
            stack.push(c);
        }
        ans
    }
}