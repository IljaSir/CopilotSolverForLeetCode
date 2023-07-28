impl Solution {
    pub fn largest_word_count(messages: Vec<String>, senders: Vec<String>) -> String {
        
        let mut map: std::collections::HashMap<String, i32> = std::collections::HashMap::new();
        for (i, s) in senders.into_iter().enumerate() {
            map.entry(s).or_insert(0);
            map.entry(s).and_modify(|v| *v += messages[i].split_whitespace().count() as i32);
        }
        let mut res = "".to_string();
        let mut max = 0;
        for (k, v) in map.into_iter() {
            if v > max {
                res = k;
                max = v;
            } else if v == max && k > res {
                res = k;
            }
        }
        res
    }
}