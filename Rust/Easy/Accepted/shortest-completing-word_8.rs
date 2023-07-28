impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut char_count: [i32;26] = [0;26];
        for c in license_plate.as_bytes() {
            if c.is_ascii_alphabetic() {
                char_count[(c.to_ascii_lowercase()-b'a') as usize] += 1;
            }
        }
        let mut ans = String::new();
        for word in words {
            let mut char_count2: [i32;26] = [0;26];
            for c in word.as_bytes() {
                char_count2[(c-b'a') as usize] += 1;
            }
            let mut ok = true;
            for i in 0..26 {
                if char_count[i] > char_count2[i] {
                    ok = false;
                    break;
                }
            }
            if ok {
                if ans.is_empty() || ans.len() > word.len() {
                    ans = word;
                }
            }
        }
        ans
    }
}