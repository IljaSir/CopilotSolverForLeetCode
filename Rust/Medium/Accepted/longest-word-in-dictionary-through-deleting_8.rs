impl Solution {
    pub fn find_longest_word(s: String, dictionary: Vec<String>) -> String {
        

        let mut result = String::new();
        let s = s.as_bytes();
        for word in dictionary {
            let word = word.as_bytes();
            let mut i = 0;
            for &c in s {
                if i < word.len() && c == word[i] {
                    i += 1;
                }
            }
            if i == word.len() && (result.is_empty() || word.len() > result.len() || (word.len() == result.len() && word < result.as_bytes())) {
                result = String::from_utf8(word.to_vec()).unwrap();
            }
        }
        result
    }
}