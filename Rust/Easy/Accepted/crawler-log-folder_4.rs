impl Solution {
    pub fn min_operations(logs: Vec<String>) -> i32 {
        
        let mut result = 0;
        for log in logs {
            match log.as_str() {
                "../" => {
                    if result > 0 {
                        result -= 1;
                    }
                },
                "./" => {},
                _ => result += 1,
            }
        }
        result
    }
}