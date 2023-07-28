impl Solution {
    pub fn sort_sentence(s: String) -> String {
        
        let mut words = s.split_whitespace().collect::<Vec<&str>>();
        words.sort_by(|a, b| a.chars().last().unwrap().cmp(&b.chars().last().unwrap()));
        words.iter().map(|w| w[..w.len() - 1].to_string()).collect::<Vec<String>>().join(" ")
    }
}