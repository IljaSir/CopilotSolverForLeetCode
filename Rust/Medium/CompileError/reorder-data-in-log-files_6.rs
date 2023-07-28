impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut letter_logs = Vec::with_capacity(logs.len());
        let mut digit_logs = Vec::with_capacity(logs.len());
        for log in logs {
            let mut iter = log.split_ascii_whitespace();
            let identifier = iter.next().unwrap();
            let first_word = iter.next().unwrap();
            if first_word.chars().all(|c| c.is_ascii_digit()) {
                digit_logs.push(format!("{} {}", identifier, first_word));
            } else {
                letter_logs.push(format!("{} {}", identifier, first_word));
            }
        }
        letter_logs.sort_unstable();
        let mut result = Vec::with_capacity(logs.len());
        for log in letter_logs {
            let mut iter = log.split_ascii_whitespace();
            let identifier = iter.next().unwrap();
            let first_word = iter.next().unwrap();
            result.push(format!("{} {} {}", identifier, first_word, iter.collect::<Vec<_>>().join(" ")));
        }
        result.extend(digit_logs);
        result
    }
}