impl Solution {
    pub fn largest_merge(word1: String, word2: String) -> String {
        
        let mut word1 = word1.into_bytes();
        let mut word2 = word2.into_bytes();
        let mut res = vec![];
        while !word1.is_empty() && !word2.is_empty() {
            if word1 > word2 {
                res.push(word1.remove(0));
            } else {
                res.push(word2.remove(0));
            }
        }
        res.append(&mut word1);
        res.append(&mut word2);
        String::from_utf8(res).unwrap()
    }
}