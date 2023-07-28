impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut license_plate = license_plate.to_lowercase();
        let mut map: Vec<i32> = vec![0; 26];
        let mut min = 16;
        let mut min_word = "".to_string();
        for c in license_plate.chars() {
            if c.is_alphabetic() {
                map[(c as u8 - b'a') as usize] += 1;
            }
        }
        for word in words {
            let mut word_map: Vec<i32> = vec![0; 26];
            for c in word.chars() {
                word_map[(c as u8 - b'a') as usize] += 1;
            }
            let mut flag = true;
            for i in 0..26 {
                if map[i] > word_map[i] {
                    flag = false;
                    break;
                }
            }
            if flag && word.len() < min {
                min = word.len();
                min_word = word;
            }
        }
        min_word
    }
}