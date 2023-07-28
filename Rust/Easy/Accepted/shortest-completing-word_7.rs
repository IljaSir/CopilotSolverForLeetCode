impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut plate = [0; 26];
        for c in license_plate.chars() {
            if c.is_ascii_alphabetic() {
                let i = c.to_ascii_lowercase() as usize - 'a' as usize;
                plate[i] += 1;
            }
        }
        let mut res = "".to_string();
        for word in words {
            let mut w = [0; 26];
            for c in word.chars() {
                let i = c as usize - 'a' as usize;
                w[i] += 1;
            }
            if w.iter().zip(plate.iter()).all(|(a, b)| a >= b) {
                if res.is_empty() || res.len() > word.len() {
                    res = word;
                }
            }
        }
        res
    }
}