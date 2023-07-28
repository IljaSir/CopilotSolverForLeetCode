impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut count = vec![0; 26];
        for c in license_plate.chars() {
            let c = c.to_ascii_lowercase();
            if c.is_ascii_alphabetic() {
                count[(c as u8 - b'a') as usize] += 1;
            }
        }
        let mut result = String::new();
        let mut min_len = 16;
        for word in words {
            let mut count_copy = count.clone();
            for c in word.chars() {
                let c = c.to_ascii_lowercase();
                if !c.is_ascii_alphabetic() { continue; }
                let idx = (c as u8 - b'a') as usize;
                count_copy[idx] -= 1;
            }
            if count_copy.iter().all(|&x| x <= 0) && word.len() < min_len {
                result = word;
                min_len = word.len();
            }
        }
        result
    }
}