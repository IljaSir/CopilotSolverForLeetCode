impl Solution {
    pub fn equal_frequency(word: String) -> bool {
        
        let mut v = vec![0; 26];
        for c in word.chars() {
            v[c as usize - 'a' as usize] += 1;
        }
        let mut count = 0;
        for i in 0..26 {
            if v[i] == 0 {
                continue;
            }
            if v[i] == 1 {
                count += 1;
            }
            if count > 1 {
                return false;
            }
        }
        true
    }
}