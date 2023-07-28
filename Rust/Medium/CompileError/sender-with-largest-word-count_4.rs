impl Solution {
    pub fn largest_word_count(messages: Vec<String>, senders: Vec<String>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for i in 0..messages.len() {
            let count = messages[i].split_whitespace().count();
            let sender = &senders[i];
            *map.entry(sender).or_insert(0) += count;
        }
        let mut max = 0;
        let mut res = "".to_string();
        for (k, v) in map {
            if v > max || (v == max && k > res) {
                max = v;
                res = k;
            }
        }
        res
    }
}