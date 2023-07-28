impl Solution {
    pub fn find_words(words: Vec<String>) -> Vec<String> {
        
        let mut res = vec![];
        let first = "qwertyuiop".chars().collect::<HashSet<_>>();
        let second = "asdfghjkl".chars().collect::<HashSet<_>>();
        let third = "zxcvbnm".chars().collect::<HashSet<_>>();
        for word in words {
            let mut set = word.to_ascii_lowercase().chars().collect::<HashSet<_>>();
            if set.is_subset(&first) || set.is_subset(&second) || set.is_subset(&third) {
                res.push(word);
            }
        }
        res
    }
}