impl Solution {
    pub fn largest_word_count(messages: Vec<String>, senders: Vec<String>) -> String {
        
        let mut map = std::collections::HashMap::new();
        for i in 0..messages.len() {
            let count = messages[i].split(' ').count();
            if let Some(x) = map.get_mut(&senders[i]) {
                *x += count;
            } else {
                map.insert(senders[i].clone(), count);
            }
        }
        let mut max = 0;
        let mut res = "".to_string();
        for (k, v) in map {
            if v > max {
                max = v;
                res = k;
            } else if v == max {
                if k > res {
                    res = k;
                }
            }
        }
        res
    }
}