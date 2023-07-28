impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        

        let mut map = std::collections::HashMap::new();
        let mut ans = Vec::new();
        for i in 0..(s.len() - 9) {
            *map.entry(&s[i..i + 10]).or_insert(0) += 1;
        }
        for (k, v) in map {
            if v > 1 {
                ans.push(k.to_string());
            }
        }
        ans
    }
}