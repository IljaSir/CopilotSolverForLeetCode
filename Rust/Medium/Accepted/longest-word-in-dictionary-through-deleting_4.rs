impl Solution {
    pub fn find_longest_word(s: String, dictionary: Vec<String>) -> String {
        

        let mut res = String::new();
        for word in dictionary {
            let mut i = 0;
            for c in s.chars() {
                if i < word.len() && c == word.chars().nth(i).unwrap() {
                    i += 1;
                }
            }
            if i == word.len() && (res.len() < word.len() || (res.len() == word.len() && res > word)) {
                res = word;
            }
        }
        res
    }
}