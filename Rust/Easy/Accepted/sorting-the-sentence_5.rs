impl Solution {
    pub fn sort_sentence(s: String) -> String {
        
        let mut words = s.split(" ").collect::<Vec<&str>>();
        words.sort_by_key(|word| word.chars().last().unwrap());
        words.iter().map(|word| &word[0..word.len()-1]).collect::<Vec<&str>>().join(" ")
    }
}