impl Solution {
    pub fn close_strings(word1: String, word2: String) -> bool {
        
        let mut c1 = vec![0; 26];
        let mut c2 = vec![0; 26];
        for c in word1.chars() {
            c1[(c as u8 - b'a') as usize] += 1;
        }
        for c in word2.chars() {
            c2[(c as u8 - b'a') as usize] += 1;
        }
        for i in 0..26 {
            if (c1[i] == 0 && c2[i] != 0) || (c1[i] != 0 && c2[i] == 0) {
                return false;
            }
        }
        c1.sort();
        c2.sort();
        c1 == c2
    }
}