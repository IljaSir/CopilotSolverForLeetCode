impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut m: HashMap<String, i32> = HashMap::new();
        let mut v: Vec<String> = vec![];
        for i in s1.split_whitespace() {
            *m.entry(i.to_string()).or_insert(0) += 1;
        }
        for i in s2.split_whitespace() {
            *m.entry(i.to_string()).or_insert(0) += 1;
        }
        for (k, v) in m {
            if v == 1 {
                v.push(k);
            }
        }
        v
    }
}