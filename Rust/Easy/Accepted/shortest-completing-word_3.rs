impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut dict = vec![0; 26];
        for c in license_plate.chars() {
            if c.is_ascii_alphabetic() {
                dict[c.to_ascii_lowercase() as usize - 97] += 1;
            }
        }
        let mut ret = String::new();
        let mut min_len = 16;
        for s in words {
            let mut tmp = dict.clone();
            for c in s.chars() {
                tmp[c as usize - 97] -= 1;
            }
            if tmp.iter().all(|&x| x <= 0) && s.len() < min_len {
                min_len = s.len();
                ret = s;
            }
        }
        ret
    }
}