impl Solution {
    pub fn largest_word_count(messages: Vec<String>, senders: Vec<String>) -> String {
        
        let mut count = std::collections::HashMap::new();
        for i in 0..messages.len() {
            let c = count.entry(senders[i].clone()).or_insert(0);
            *c += messages[i].split_whitespace().count();
        }
        let mut max = 0;
        let mut ans = "".to_string();
        for (k, v) in count {
            if v > max {
                max = v;
                ans = k;
            } else if v == max && k > ans {
                ans = k;
            }
        }
        ans
    }
}