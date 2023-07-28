impl Solution {
    pub fn calculate(s: String) -> i32 {
        

        let mut stack = Vec::new();
        let mut num = 0;
        let mut sign = '+';
        let s = s.as_bytes();
        for (i, &c) in s.iter().enumerate() {
            if c.is_ascii_digit() {
                num = num * 10 + (c - b'0') as i32;
            }
            if (!c.is_ascii_digit() && c != b' ') || i == s.len() - 1 {
                match sign {
                    '+' => stack.push(num),
                    '-' => stack.push(-num),
                    '*' => {
                        let tmp = stack.pop().unwrap();
                        stack.push(tmp * num);
                    }
                    '/' => {
                        let tmp = stack.pop().unwrap();
                        stack.push(tmp / num);
                    }
                    _ => (),
                }
                sign = c as char;
                num = 0;
            }
        }
        stack.iter().sum()
    }
}