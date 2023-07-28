impl Solution {
    pub fn sort_sentence(s: String) -> String {
        
        let mut words: Vec<String> = s.split_whitespace().map(|w| w.to_string()).collect();
        words.sort_by(|a, b| {
            let a = &a[a.len()-1..];
            let b = &b[b.len()-1..];
            a.cmp(b)
        });
        words.iter().map(|w| w[0..w.len()-1].to_string()).collect::<Vec<String>>().join(" ")
    }
}