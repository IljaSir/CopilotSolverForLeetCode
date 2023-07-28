impl Solution {
    pub fn check_almost_equivalent(word1: String, word2: String) -> bool {
        
        let mut a = vec![0; 26];
        let mut b = vec![0; 26];
        for c in word1.chars() {
            a[(c as u8 - 'a' as u8) as usize] += 1;
        }
        for c in word2.chars() {
            b[(c as u8 - 'a' as u8) as usize] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            diff += (a[i] - b[i]).abs();
        }
        diff <= 3
    }
}