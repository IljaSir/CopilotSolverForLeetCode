impl Solution {
    pub fn decode_string(s: String) -> String {
        

        let mut stack = Vec::new();
        let mut num = 0;
        let mut res = String::new();
        for c in s.chars() {
            if c.is_numeric() {
                num = num * 10 + c.to_digit(10).unwrap() as usize;
            } else if c == '[' {
                stack.push((num, res.clone()));
                num = 0;
                res = String::new();
            } else if c == ']' {
                let (n, s) = stack.pop().unwrap();
                res = s + &res.repeat(n);
            } else {
                res.push(c);
            }
        }
        res
    }
}