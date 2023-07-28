impl Solution {
    pub fn reverse_words(s: String) -> String {
        

        let mut words = s.split_whitespace().collect::<Vec<&str>>();
        words.reverse();
        words.join(" ")
    }
}