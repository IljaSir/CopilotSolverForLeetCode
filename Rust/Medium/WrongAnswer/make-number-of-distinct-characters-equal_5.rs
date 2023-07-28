impl Solution {
    pub fn is_it_possible(word1: String, word2: String) -> bool {
        
        let mut c1 = vec![0; 26];
        let mut c2 = vec![0; 26];
        let mut l1 = 0;
        let mut l2 = 0;
        for c in word1.chars() {
            c1[c as usize - 'a' as usize] += 1;
            l1 += 1;
        }
        for c in word2.chars() {
            c2[c as usize - 'a' as usize] += 1;
            l2 += 1;
        }
        let mut diff = 0;
        for i in 0..26 {
            if c1[i] > 0 && c2[i] == 0 {
                diff += 1;
            }
            if c1[i] == 0 && c2[i] > 0 {
                diff += 1;
            }
        }
        let mut same = 0;
        for i in 0..26 {
            same += c1[i].min(c2[i]);
        }
        if diff <= 2 && same >= l1 - 2 && same >= l2 - 2 {
            return true;
        }
        false
    }
}