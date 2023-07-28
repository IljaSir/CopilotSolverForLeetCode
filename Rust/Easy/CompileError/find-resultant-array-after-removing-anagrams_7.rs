impl Solution {
    pub fn remove_anagrams(words: Vec<String>) -> Vec<String> {
        
        let mut res: Vec<String> = Vec::new();
        let mut dict: HashMap<String, i32> = HashMap::new();
        for word in words {
            let mut tmp: Vec<char> = word.chars().collect();
            tmp.sort();
            let tmp = tmp.iter().collect::<String>();
            if !dict.contains_key(&tmp) {
                res.push(word);
                dict.insert(tmp, 1);
            }
        }
        res
    }
}