impl Solution {
    pub fn close_strings(word1: String, word2: String) -> bool {
        
        let mut c1 = vec![0; 26];
        let mut c2 = vec![0; 26];
        let mut s1 = vec![0; 26];
        let mut s2 = vec![0; 26];
        for c in word1.chars() {
            c1[c as usize - 'a' as usize] += 1;
            s1[c as usize - 'a' as usize] = 1;
        }
        for c in word2.chars() {
            c2[c as usize - 'a' as usize] += 1;
            s2[c as usize - 'a' as usize] = 1;
        }
        c1.sort();
        c2.sort();
        s1.sort();
        s2.sort();
        c1 == c2 && s1 == s2
    }
}