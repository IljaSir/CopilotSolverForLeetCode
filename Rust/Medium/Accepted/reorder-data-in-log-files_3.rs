impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut letter_logs = Vec::new();
        let mut digit_logs = Vec::new();
        for log in logs {
            let mut iter = log.split(' ');
            let id = iter.next().unwrap().to_string();
            let content = iter.collect::<Vec<&str>>().join(" ");
            if content.chars().next().unwrap().is_digit(10) {
                digit_logs.push(log);
            } else {
                letter_logs.push((id, content));
            }
        }
        letter_logs.sort_by(|a, b| {
            let cmp = a.1.cmp(&b.1);
            if cmp == std::cmp::Ordering::Equal {
                a.0.cmp(&b.0)
            } else {
                cmp
            }
        });
        letter_logs
            .into_iter()
            .map(|(id, content)| format!("{} {}", id, content))
            .chain(digit_logs.into_iter())
            .collect()
    }
}