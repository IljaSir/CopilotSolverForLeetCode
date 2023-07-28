impl Solution {
    pub fn close_strings(word1: String, word2: String) -> bool {
        
        let mut cnt1 = [0; 26];
        let mut cnt2 = [0; 26];
        let mut used1 = [false; 26];
        let mut used2 = [false; 26];
        for c in word1.chars() {
            cnt1[c as usize - 'a' as usize] += 1;
            used1[c as usize - 'a' as usize] = true;
        }
        for c in word2.chars() {
            cnt2[c as usize - 'a' as usize] += 1;
            used2[c as usize - 'a' as usize] = true;
        }
        if used1 != used2 {
            return false;
        }
        cnt1.sort();
        cnt2.sort();
        cnt1 == cnt2
    }
}