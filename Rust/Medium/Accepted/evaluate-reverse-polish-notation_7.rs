impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        

        let mut stack = Vec::new();
        for token in tokens {
            if let Ok(i) = token.parse::<i32>() {
                stack.push(i);
            } else {
                let b = stack.pop().unwrap();
                let a = stack.pop().unwrap();
                let v = match token.as_str() {
                    "+" => a + b,
                    "-" => a - b,
                    "*" => a * b,
                    "/" => a / b,
                    _ => 0,
                };
                stack.push(v);
            }
        }
        stack.pop().unwrap()
    }
}