impl Solution {
    pub fn reverse_words(s: String) -> String {
        

        let mut v: Vec<&str> = s.split_whitespace().collect();
        v.reverse();
        v.join(" ")
    }
}