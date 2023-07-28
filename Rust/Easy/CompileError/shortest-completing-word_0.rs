impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut counts = vec![0; 26];
        for c in license_plate.chars() {
            if c.is_ascii_alphabetic() {
                counts[c.to_ascii_lowercase() as usize - 'a' as usize] += 1;
            }
        }
        let mut result = String::new();
        let mut min_len = usize::MAX;
        for word in words {
            if word.len() < min_len {
                if Self::is_completing(&counts, &word) {
                    result = word;
                    min_len = word.len();
                }
            }
        }
        result
    }
    fn is_completing(counts: &Vec<i32>, word: &String) -> bool {
        let mut counts = counts.clone();
        for c in word.chars() {
            counts[c as usize - 'a' as usize] -= 1;
            if counts[c as usize - 'a' as usize] < 0 {
                return false;
            }
        }
        true
    }
}