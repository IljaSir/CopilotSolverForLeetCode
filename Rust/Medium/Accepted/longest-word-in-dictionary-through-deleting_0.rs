impl Solution {
    pub fn find_longest_word(s: String, dictionary: Vec<String>) -> String {
        

        let mut dict = dictionary;
        dict.sort_by(|a, b| {
            if a.len() == b.len() {
                a.cmp(b)
            } else {
                b.len().cmp(&a.len())
            }
        });
        for word in dict {
            if Solution::is_subsequence(&s, &word) {
                return word;
            }
        }
        return String::new();
    }
    fn is_subsequence(s: &str, t: &str) -> bool {
        let mut i = 0;
        let mut j = 0;
        while i < s.len() && j < t.len() {
            if s[i..i+1] == t[j..j+1] {
                j += 1;
            }
            i += 1;
        }
        return j == t.len();
    }
}