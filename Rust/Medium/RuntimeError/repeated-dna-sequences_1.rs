impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        

        let mut map = std::collections::HashMap::new();
        let mut res = vec![];
        for i in 0..s.len() - 9 {
            let seq = &s[i..i + 10];
            *map.entry(seq).or_insert(0) += 1;
            if map[seq] == 2 {
                res.push(seq.to_string());
            }
        }
        res
    }
}