impl Solution {
    pub fn shortest_completing_word(license_plate: String, words: Vec<String>) -> String {
        
        let mut map = vec![0; 26];
        for c in license_plate.chars() {
            if c.is_alphabetic() {
                map[c.to_ascii_lowercase() as usize - 'a' as usize] += 1;
            }
        }
        let mut ans = String::from("");
        for w in words {
            let mut tmp = vec![0; 26];
            for c in w.chars() {
                tmp[c as usize - 'a' as usize] += 1;
            }
            let mut ok = true;
            for i in 0..26 {
                if map[i] > tmp[i] {
                    ok = false;
                    break;
                }
            }
            if ok {
                if ans.len() == 0 {
                    ans = w;
                } else if ans.len() > w.len() {
                    ans = w;
                }
            }
        }
        ans
    }
}