impl Solution {
    pub fn find_all_concatenated_words_in_a_dict(words: Vec<String>) -> Vec<String> {
        
        let mut words: Vec<_> = words.into_iter().map(|s| s.into_bytes()).collect();
        words.sort_by_key(|s| s.len());
        let mut res: Vec<String> = vec![];
        let mut set: HashSet<Vec<u8>> = HashSet::new();
        for word in words {
            if word.len() == 0 { continue; }
            if word.len() == 1 {
                set.insert(word);
                continue;
            }
            if Self::can_form(&word, &set) {
                res.push(String::from_utf8(word).unwrap());
            }
            set.insert(word);
        }
        res
    }
    
    fn can_form(word: &[u8], set: &HashSet<Vec<u8>>) -> bool {
        if word.len() == 0 { return true; }
        let mut dp: Vec<bool> = vec![false; word.len()+1];
        dp[0] = true;
        for i in 0..word.len() {
            if !dp[i] { continue; }
            for j in i+1..word.len()+1 {
                if set.contains(&word[i..j].to_vec()) {
                    dp[j] = true;
                }
            }
        }
        dp[word.len()]
    }
}