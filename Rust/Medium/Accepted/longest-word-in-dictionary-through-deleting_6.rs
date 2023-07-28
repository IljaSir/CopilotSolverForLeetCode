impl Solution {
    pub fn find_longest_word(s: String, dictionary: Vec<String>) -> String {
        

        let mut ret = "".to_string();
        for word in dictionary {
            let mut i = 0;
            for c in s.chars() {
                if i < word.len() && word.chars().nth(i).unwrap() == c {
                    i += 1;
                }
            }
            if i == word.len() {
                if ret.len() < word.len() || (ret.len() == word.len() && ret > word) {
                    ret = word;
                }
            }
        }
        ret
    }
}