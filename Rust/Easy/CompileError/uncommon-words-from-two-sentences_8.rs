impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        let mut map: HashMap<String, i32> = HashMap::new();
        for s in s1.split(' ') {
            let count = map.entry(s.to_string()).or_insert(0);
            *count += 1;
        }
        for s in s2.split(' ') {
            let count = map.entry(s.to_string()).or_insert(0);
            *count += 1;
        }
        
        for (k, v) in map {
            if v == 1 {
                res.push(k);
            }
        }
        res
    }
}