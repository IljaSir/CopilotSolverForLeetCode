impl Solution {
    pub fn close_strings(word1: String, word2: String) -> bool {
        
        let mut w1 = word1.into_bytes();
        let mut w2 = word2.into_bytes();
        w1.sort();
        w2.sort();
        if w1 != w2 {
            return false;
        }
        let mut c1 = vec![0; 26];
        let mut c2 = vec![0; 26];
        for i in 0..w1.len() {
            c1[(w1[i] - b'a') as usize] += 1;
            c2[(w2[i] - b'a') as usize] += 1;
        }
        c1.sort();
        c2.sort();
        c1 == c2
    }
}