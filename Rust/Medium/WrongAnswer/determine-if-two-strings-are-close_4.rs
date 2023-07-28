impl Solution {
    pub fn close_strings(word1: String, word2: String) -> bool {
        
        let mut a = [0; 26];
        let mut b = [0; 26];
        for c in word1.chars() {
            a[c as usize - 97] += 1;
        }
        for c in word2.chars() {
            b[c as usize - 97] += 1;
        }
        a.iter().zip(b.iter()).all(|(x, y)| x == y && (x == &0 || y != &0)) && a.iter().any(|&x| x != 0) && b.iter().any(|&x| x != 0)
    }
}