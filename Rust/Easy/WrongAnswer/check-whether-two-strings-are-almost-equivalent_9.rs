impl Solution {
    pub fn check_almost_equivalent(word1: String, word2: String) -> bool {
        
        let mut char_map1: [i32; 26] = [0; 26];
        let mut char_map2: [i32; 26] = [0; 26];
        for c in word1.chars() {
            char_map1[c as usize - 'a' as usize] += 1;
        }
        for c in word2.chars() {
            char_map2[c as usize - 'a' as usize] += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            diff += (char_map1[i] - char_map2[i]).abs();
        }
        diff <= 6
    }
}