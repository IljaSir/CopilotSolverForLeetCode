impl Solution {
    pub fn find_longest_word(s: String, dictionary: Vec<String>) -> String {
        

        let mut d = dictionary;
        d.sort_unstable_by(|a, b| {
            if a.len() == b.len() {
                a.cmp(b)
            } else {
                b.len().cmp(&a.len())
            }
        });
        let mut ans = String::new();
        for word in d {
            let mut i = 0;
            for c in s.chars() {
                if i < word.len() && word.chars().nth(i).unwrap() == c {
                    i += 1;
                }
            }
            if i == word.len() {
                ans = word;
                break;
            }
        }
        ans
    }
}