impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut letter_logs: Vec<String> = Vec::new();
        let mut digit_logs: Vec<String> = Vec::new();
        for log in logs {
            let mut iter = log.split_whitespace();
            let identifier = iter.next().unwrap();
            let mut words: Vec<String> = Vec::new();
            for word in iter {
                words.push(word.to_string());
            }
            if words[0].parse::<u32>().is_ok() {
                digit_logs.push(log.to_string());
            } else {
                letter_logs.push(log.to_string());
            }
        }
        letter_logs.sort_by(|a, b| {
            let mut iter_a = a.split_whitespace();
            let mut iter_b = b.split_whitespace();
            let identifier_a = iter_a.next().unwrap();
            let identifier_b = iter_b.next().unwrap();
            let mut words_a: Vec<String> = Vec::new();
            let mut words_b: Vec<String> = Vec::new();
            for word in iter_a {
                words_a.push(word.to_string());
            }
            for word in iter_b {
                words_b.push(word.to_string());
            }
            if words_a == words_b {
                identifier_a.cmp(identifier_b)
            } else {
                words_a.cmp(&words_b)
            }
        });
        let mut result: Vec<String> = Vec::new();
        result.append(&mut letter_logs);
        result.append(&mut digit_logs);
        result
    }
}