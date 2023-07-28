impl Solution {
    pub fn largest_word_count(messages: Vec<String>, senders: Vec<String>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for i in 0..messages.len() {
            let count = messages[i].split(' ').count();
            let sender = &senders[i];
            map.entry(sender).and_modify(|e| *e += count).or_insert(count);
        }
        let mut max = 0;
        let mut result = String::new();
        for (sender, count) in map {
            if count > max {
                max = count;
                result = sender.to_string();
            } else if count == max && sender > result {
                result = sender.to_string();
            }
        }
        result
    }
}