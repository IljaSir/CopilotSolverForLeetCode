impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        

        let mut map = std::collections::HashMap::new();
        let mut res = Vec::new();
        for i in 0..s.len() - 9 {
            let key = &s[i..i + 10];
            *map.entry(key).or_insert(0) += 1;
            if map[key] == 2 {
                res.push(key.to_string());
            }
        }
        res
    }
}