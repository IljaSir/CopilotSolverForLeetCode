impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut letter_logs = Vec::new();
        let mut digit_logs = Vec::new();
        for log in logs {
            let mut iter = log.split_whitespace();
            let id = iter.next().unwrap().to_owned();
            let content = iter.next().unwrap().to_owned();
            if content.chars().next().unwrap().is_ascii_digit() {
                digit_logs.push((id, content));
            } else {
                letter_logs.push((id, content));
            }
        }
        letter_logs.sort_by_key(|x| (x.1.clone(), x.0.clone()));
        let mut res = Vec::new();
        for (id, content) in letter_logs {
            res.push(format!("{} {}", id, content));
        }
        for (id, content) in digit_logs {
            res.push(format!("{} {}", id, content));
        }
        res
    }
}