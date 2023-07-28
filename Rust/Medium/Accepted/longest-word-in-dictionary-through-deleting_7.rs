impl Solution {
    pub fn find_longest_word(s: String, dictionary: Vec<String>) -> String {
        

        let mut res = String::new();
        for w in dictionary {
            if w.len() < res.len() || w.len() == res.len() && w > res {
                continue;
            }
            if Self::is_subseq(&s, &w) {
                res = w;
            }
        }
        res
    }
    
    fn is_subseq(s: &str, w: &str) -> bool {
        let mut i = 0;
        for c in s.chars() {
            if i == w.len() {
                break;
            }
            if c == w.chars().nth(i).unwrap() {
                i += 1;
            }
        }
        i == w.len()
    }
}