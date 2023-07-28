impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        

        let mut stack = Vec::new();
        for token in tokens {
            if token == "+" || token == "-" || token == "*" || token == "/" {
                let b = stack.pop().unwrap();
                let a = stack.pop().unwrap();
                let c = match token.as_str() {
                    "+" => a + b,
                    "-" => a - b,
                    "*" => a * b,
                    "/" => a / b,
                    _ => 0,
                };
                stack.push(c);
            } else {
                stack.push(token.parse::<i32>().unwrap());
            }
        }
        stack.pop().unwrap()
    }
}