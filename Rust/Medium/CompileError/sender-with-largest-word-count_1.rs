impl Solution {
    pub fn largest_word_count(messages: Vec<String>, senders: Vec<String>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for (i, s) in senders.iter().enumerate() {
            let count = map.entry(s).or_insert(0);
            *count += messages[i].split(' ').count();
        }
        let mut max = 0;
        let mut ans = "".to_string();
        for (key, value) in map {
            if value > max {
                max = value;
                ans = key.to_string();
            } else if value == max {
                if key > ans {
                    ans = key.to_string();
                }
            }
        }
        ans
    }
}