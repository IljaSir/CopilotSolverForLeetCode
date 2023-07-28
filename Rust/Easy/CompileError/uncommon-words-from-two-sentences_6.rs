impl Solution {
    pub fn uncommon_from_sentences(s1: String, s2: String) -> Vec<String> {
        
        let mut s1 = s1.split(" ");
        let mut s2 = s2.split(" ");
        let mut s1_map = HashMap::new();
        let mut s2_map = HashMap::new();
        let mut res = Vec::new();
        for i in s1 {
            if s1_map.contains_key(i) {
                s1_map.insert(i, s1_map.get(i).unwrap() + 1);
            } else {
                s1_map.insert(i, 1);
            }
        }
        for i in s2 {
            if s2_map.contains_key(i) {
                s2_map.insert(i, s2_map.get(i).unwrap() + 1);
            } else {
                s2_map.insert(i, 1);
            }
        }
        for (k, v) in s1_map {
            if !s2_map.contains_key(k) && v == 1 {
                res.push(k.to_string());
            }
        }
        for (k, v) in s2_map {
            if !s1_map.contains_key(k) && v == 1 {
                res.push(k.to_string());
            }
        }
        res
    }
}