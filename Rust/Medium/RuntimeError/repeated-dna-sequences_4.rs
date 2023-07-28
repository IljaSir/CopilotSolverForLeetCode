impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        

        let mut res = vec![];
        let mut map = std::collections::HashMap::new();
        for i in 0..(s.len() - 9) {
            let sub = &s[i..(i + 10)];
            let count = map.entry(sub.to_string()).or_insert(0);
            *count += 1;
            if *count == 2 {
                res.push(sub.to_string());
            }
        }
        res
    }
}