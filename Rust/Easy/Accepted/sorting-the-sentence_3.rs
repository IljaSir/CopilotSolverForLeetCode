impl Solution {
    pub fn sort_sentence(s: String) -> String {
        
        let mut words = s.split(' ').collect::<Vec<&str>>();
        words.sort_by_key(|w| w.as_bytes()[w.len() - 1]);
        words.iter().map(|w| &w[..w.len() - 1]).collect::<Vec<&str>>().join(" ")
    }
}