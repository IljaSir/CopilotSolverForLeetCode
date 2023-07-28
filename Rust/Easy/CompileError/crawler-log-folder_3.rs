impl Solution {
    pub fn min_operations(logs: Vec<String>) -> i32 {
        
        let mut depth = 0;
        for log in logs {
            match log.as_str() {
                "../" => depth = depth.saturating_sub(1),
                "./" => (),
                _ => depth += 1,
            }
        }
        depth
    }
}