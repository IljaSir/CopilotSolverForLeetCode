impl Solution {
    pub fn reverse_words(s: String) -> String {
        

        let s = s.trim();
        let mut s = s.split_whitespace();
        let mut res = String::new();
        while let Some(word) = s.next() {
            res.insert_str(0, word);
            res.insert(0, ' ');
        }
        res.trim().to_string()
    }
}