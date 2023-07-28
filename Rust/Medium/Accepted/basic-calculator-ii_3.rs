impl Solution {
    pub fn calculate(s: String) -> i32 {
        

        let mut stack: Vec<i32> = Vec::new();
        let mut num = 0;
        let mut op = '+';
        for (i, c) in s.chars().enumerate() {
            if c.is_ascii_digit() {
                num = num * 10 + (c as u8 - b'0') as i32;
            }
            if !c.is_ascii_digit() && c != ' ' || i == s.len() - 1 {
                match op {
                    '+' => {
                        stack.push(num);
                    }
                    '-' => {
                        stack.push(-num);
                    }
                    '*' => {
                        let tmp = stack.pop().unwrap();
                        stack.push(tmp * num);
                    }
                    '/' => {
                        let tmp = stack.pop().unwrap();
                        stack.push(tmp / num);
                    }
                    _ => {}
                }
                op = c;
                num = 0;
            }
        }
        stack.iter().sum()
    }
}