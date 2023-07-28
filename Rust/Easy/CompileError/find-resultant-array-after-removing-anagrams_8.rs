impl Solution {
    pub fn remove_anagrams(words: Vec<String>) -> Vec<String> {
        
        let mut res = Vec::new();
        let mut map: HashMap<String, usize> = HashMap::new();
        for (i, w) in words.iter().enumerate() {
            let mut v: Vec<char> = w.chars().collect();
            v.sort();
            let s = v.iter().collect::<String>();
            let n = map.entry(s).or_insert(0);
            if *n == 0 {
                res.push(w.clone());
            }
            *n += 1;
        }
        res
    }
}