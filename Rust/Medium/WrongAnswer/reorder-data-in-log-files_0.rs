impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut result: Vec<String> = Vec::new();
        let mut digit_logs: Vec<String> = Vec::new();
        let mut letter_logs: Vec<String> = Vec::new();
        for log in logs {
            let mut log_parts: Vec<&str> = log.split(' ').collect();
            if log_parts[1].chars().next().unwrap().is_digit(10) {
                digit_logs.push(log_parts.join(" "));
            } else {
                let mut letter_log = log_parts[1..].join(" ");
                letter_log.push_str(" ");
                letter_log.push_str(log_parts[0]);
                letter_logs.push(letter_log);
            }
        }
        letter_logs.sort_unstable();
        for log in letter_logs {
            let mut log_parts: Vec<&str> = log.split(' ').collect();
            result.push(log_parts[1..].join(" "));
        }
        result.append(&mut digit_logs);
        result
    }
}