impl Solution {
    pub fn find_repeated_dna_sequences(s: String) -> Vec<String> {
        

        let mut res: Vec<String> = vec![];
        let mut map: HashMap<String, i32> = HashMap::new();
        let mut i = 0;
        while i + 10 <= s.len() {
            let sub = &s[i..i+10];
            let count = map.entry(sub.to_string()).or_insert(0);
            *count += 1;
            if *count == 2 {
                res.push(sub.to_string());
            }
            i += 1;
        }
        res
    }
}