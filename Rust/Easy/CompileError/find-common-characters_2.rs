impl Solution {
    pub fn common_chars(words: Vec<String>) -> Vec<String> {
        
        let mut result = Vec::new();
        let mut chars: Vec<Vec<char>> = words.iter().map(|s| s.chars().collect()).collect();
        chars.sort_by(|a, b| a.len().cmp(&b.len()));
        let mut chars = chars.iter();
        let mut first = chars.next().unwrap();
        for c in first {
            let mut found = true;
            for word in chars.clone() {
                if let Some(pos) = word.iter().position(|&x| x == *c) {
                    word.remove(pos);
                } else {
                    found = false;
                    break;
                }
            }
            if found {
                result.push(c.to_string());
            }
        }
        result
    }
}