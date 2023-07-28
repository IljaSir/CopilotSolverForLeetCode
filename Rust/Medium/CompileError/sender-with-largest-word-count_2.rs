impl Solution {
    pub fn largest_word_count(messages: Vec<String>, senders: Vec<String>) -> String {
        
        let mut sender_count = std::collections::HashMap::new();
        for (i, sender) in senders.iter().enumerate() {
            let count = sender_count.entry(sender).or_insert(0);
            *count += messages[i].split(' ').count();
        }
        let mut max = 0;
        let mut max_sender = String::new();
        for (sender, count) in sender_count.iter() {
            if *count > max || (*count == max && sender > &max_sender) {
                max = *count;
                max_sender = sender.clone();
            }
        }
        max_sender
    }
}