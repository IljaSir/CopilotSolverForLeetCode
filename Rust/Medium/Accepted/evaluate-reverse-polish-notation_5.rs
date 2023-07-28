impl Solution {
    pub fn eval_rpn(tokens: Vec<String>) -> i32 {
        

        let mut stack = Vec::new();
        for token in tokens {
            match token.as_str() {
                "+" => {
                    let x = stack.pop().unwrap();
                    let y = stack.pop().unwrap();
                    stack.push(x + y);
                }
                "-" => {
                    let x = stack.pop().unwrap();
                    let y = stack.pop().unwrap();
                    stack.push(y - x);
                }
                "*" => {
                    let x = stack.pop().unwrap();
                    let y = stack.pop().unwrap();
                    stack.push(x * y);
                }
                "/" => {
                    let x = stack.pop().unwrap();
                    let y = stack.pop().unwrap();
                    stack.push(y / x);
                }
                _ => {
                    stack.push(token.parse::<i32>().unwrap());
                }
            }
        }
        stack.pop().unwrap()
    }
}