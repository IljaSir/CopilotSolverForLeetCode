impl Solution {
    pub fn sort_sentence(s: String) -> String {
        
        let mut words = s.split(" ").collect::<Vec<_>>();
        words.sort_by(|a, b| a[a.len() - 1..].cmp(&b[b.len() - 1..]));
        words.iter().map(|w| w[..w.len() - 1].to_string()).collect::<Vec<_>>().join(" ")
    }
}