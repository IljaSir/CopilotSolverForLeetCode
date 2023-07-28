impl Solution {
    pub fn calculate(s: String) -> i32 {
        

        let mut num = 0;
        let mut res = 0;
        let mut sign = 1;
        let mut stack = vec![];
        for c in s.chars() {
            if c.is_digit(10) {
                num = num * 10 + c.to_digit(10).unwrap() as i32;
            } else if c == '+' {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if c == '-' {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if c == '*' {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if c == '/' {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = -1;
            }
        }
        res += sign * num;
        while !stack.is_empty() {
            res *= stack.pop().unwrap();
            res += stack.pop().unwrap();
        }
        res
    }
}