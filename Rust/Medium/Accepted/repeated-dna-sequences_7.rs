impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        

        let mut res: Vec<String> = vec![];
        let mut map: std::collections::HashMap<u32, u32> = std::collections::HashMap::new();
        let mut h: u32 = 0;
        for (i, c) in s.chars().enumerate() {
            h <<= 2;
            h |= match c {
                'A' => 0,
                'C' => 1,
                'G' => 2,
                'T' => 3,
                _ => 0,
            };
            if i < 9 {
                continue;
            }
            h &= 0xfffff;
            if let Some(&v) = map.get(&h) {
                if v == 1 {
                    res.push(s[i - 9..=i].to_string());
                }
                map.insert(h, v + 1);
            } else {
                map.insert(h, 1);
            }
        }
        res
    }
}