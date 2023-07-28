impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut letter_logs = Vec::new();
        let mut digit_logs = Vec::new();
        for log in logs {
            let mut iter = log.split(' ');
            let id = iter.next().unwrap();
            let content = iter.next().unwrap();
            if content.chars().nth(0).unwrap().is_ascii_digit() {
                digit_logs.push(log);
            } else {
                letter_logs.push((id, content));
            }
        }
        letter_logs.sort_by(|a, b| {
            if a.1 == b.1 {
                a.0.cmp(b.0)
            } else {
                a.1.cmp(b.1)
            }
        });
        let mut result = Vec::new();
        for log in letter_logs {
            result.push(format!("{} {}", log.0, log.1));
        }
        for log in digit_logs {
            result.push(log);
        }
        result
    }
}