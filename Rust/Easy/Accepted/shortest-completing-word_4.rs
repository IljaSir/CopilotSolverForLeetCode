impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut license = vec![0; 26];
        for c in license_plate.chars() {
            if c.is_alphabetic() {
                license[c.to_ascii_lowercase() as usize - 'a' as usize] += 1;
            }
        }
        let mut ans = "".to_string();
        for word in words {
            let mut word = word;
            let mut word_vec = vec![0; 26];
            for c in word.chars() {
                word_vec[c as usize - 'a' as usize] += 1;
            }
            let mut ok = true;
            for i in 0..26 {
                if word_vec[i] < license[i] {
                    ok = false;
                    break;
                }
            }
            if ok && (ans == "" || ans.len() > word.len()) {
                ans = word;
            }
        }
        ans
    }
}