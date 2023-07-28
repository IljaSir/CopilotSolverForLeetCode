impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        

        use std::collections::HashMap;
        let mut map = HashMap::new();
        let mut res = Vec::new();
        for i in 0..s.len() - 9 {
            let seq = &s[i..i + 10];
            let count = map.entry(seq).or_insert(0);
            *count += 1;
            if *count == 2 {
                res.push(seq.to_string());
            }
        }
        res
    }
}