impl Solution {
    pub fn maximum_gain(s: String, x: i32, y: i32) -> i32 {
        
        let (x, y) = if x > y { (x, y, "ab", "ba") } else { (y, x, "ba", "ab") };
        let mut stack = Vec::new();
        let mut res = 0;
        for c in s.chars() {
            if let Some(&last) = stack.last() {
                if last == c {
                    stack.push(c);
                } else if last == x.2.chars().nth(0).unwrap() && c == x.2.chars().nth(1).unwrap() {
                    stack.pop();
                    res += x;
                } else if last == y.2.chars().nth(0).unwrap() && c == y.2.chars().nth(1).unwrap() {
                    stack.pop();
                    res += y;
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        res
    }
}