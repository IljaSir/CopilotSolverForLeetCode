impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        

        let mut res = Vec::new();
        let mut map = std::collections::HashMap::new();
        let bytes = s.as_bytes();
        for i in 0..(bytes.len() - 9) {
            let mut j = i + 1;
            while j < (bytes.len() - 9) {
                if bytes[i..(i + 10)] == bytes[j..(j + 10)] {
                    let key = String::from_utf8(bytes[i..(i + 10)].to_vec()).unwrap();
                    if !map.contains_key(&key) {
                        map.insert(key, 1);
                        res.push(key);
                    }
                }
                j += 1;
            }
        }
        res
    }
}