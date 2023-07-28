impl Solution {
    pub fn is_it_possible(word1: String, word2: String) -> bool {
        
        let mut c1 = [0; 26];
        let mut c2 = [0; 26];
        for c in word1.chars() {
            c1[c as usize - 'a' as usize] += 1;
        }
        for c in word2.chars() {
            c2[c as usize - 'a' as usize] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            if c1[i] > 0 && c2[i] == 0 {
                diff += 1;
            }
            if c2[i] > 0 && c1[i] == 0 {
                diff -= 1;
            }
        }
        let mut sum = 0;
        for i in 0..26 {
            sum += (c1[i] - c2[i]).abs();
        }
        sum / 2 <= diff.abs()
    }
}