impl Solution {
    pub fn calculate(s: String) -> i32 {
        

        let mut stack: Vec<i32> = Vec::new();
        let mut num = 0;
        let mut sign = '+';
        let mut i = 0;
        while i < s.len() {
            let c = s.chars().nth(i).unwrap();
            if c.is_numeric() {
                num = num * 10 + c.to_digit(10).unwrap() as i32;
            }
            if ((!c.is_numeric() && c != ' ') || i == s.len() - 1) && c != ' ' {
                match sign {
                    '+' => stack.push(num),
                    '-' => stack.push(-num),
                    '*' => {
                        let top = stack.pop().unwrap();
                        stack.push(top * num);
                    }
                    '/' => {
                        let top = stack.pop().unwrap();
                        stack.push(top / num);
                    }
                    _ => {}
                }
                sign = c;
                num = 0;
            }
            i += 1;
        }
        stack.iter().sum()
    }
}