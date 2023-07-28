impl Solution {
    pub fn min_operations(logs: Vec<String>) -> i32 {
        
        let mut stack: Vec<String> = Vec::new();
        for log in logs {
            match log.as_str() {
                "../" => {
                    if stack.len() > 0 {
                        stack.pop();
                    }
                },
                "./" => {
                    continue;
                },
                _ => {
                    stack.push(log);
                }
            }
        }
        return stack.len() as i32;
    }
}