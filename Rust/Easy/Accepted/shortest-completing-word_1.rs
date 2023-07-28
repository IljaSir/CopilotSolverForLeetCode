impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut count = vec![0; 26];
        for c in license_plate.chars() {
            if c.is_ascii_alphabetic() {
                count[c.to_ascii_lowercase() as usize - 97] += 1;
            }
        }
        let mut ans = String::new();
        for word in words {
            if ans.len() > 0 && ans.len() <= word.len() {
                continue;
            }
            let mut count2 = vec![0; 26];
            for c in word.chars() {
                count2[c as usize - 97] += 1;
            }
            let mut ok = true;
            for i in 0..26 {
                if count[i] > count2[i] {
                    ok = false;
                    break;
                }
            }
            if ok {
                ans = word;
            }
        }
        ans
    }
}