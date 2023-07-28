impl Solution {
    pub fn reorder_log_files(logs: Vec<String>) -> Vec<String> {
        
        let mut letter_logs = Vec::new();
        let mut digit_logs = Vec::new();
        for log in logs {
            let mut iter = log.split(' ');
            let id = iter.next().unwrap();
            let content = iter.collect::<Vec<&str>>().join(" ");
            if content.chars().next().unwrap().is_alphabetic() {
                letter_logs.push((id, content));
            } else {
                digit_logs.push(log);
            }
        }
        let mut letter_logs = letter_logs.into_iter().collect::<Vec<(String, String)>>();
        letter_logs.sort_by(|a, b| a.1.cmp(&b.1).then(a.0.cmp(&b.0)));
        let letter_logs = letter_logs.into_iter().map(|(id, content)| format!("{} {}", id, content)).collect::<Vec<String>>();
        let mut res = Vec::new();
        res.extend(letter_logs);
        res.extend(digit_logs);
        res
    }
}