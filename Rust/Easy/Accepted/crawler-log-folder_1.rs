impl Solution {
    pub fn min_operations(logs: Vec<String>) -> i32 {
        
        let mut depth = 0;
        for log in logs {
            if log == "./" {
                continue;
            } else if log == "../" {
                if depth > 0 {
                    depth -= 1;
                }
            } else {
                depth += 1;
            }
        }
        depth
    }
}