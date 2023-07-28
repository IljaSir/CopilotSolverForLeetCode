impl Solution {
    pub fn is_it_possible(word1: String, word2: String) -> bool {
        
        let mut c1 = [0;26];
        let mut c2 = [0;26];
        let mut n1 = 0;
        let mut n2 = 0;
        for c in word1.chars() {
            let i = (c as u8 - 'a' as u8) as usize;
            if c1[i] == 0 {
                n1 += 1;
            }
            c1[i] += 1;
        }
        for c in word2.chars() {
            let i = (c as u8 - 'a' as u8) as usize;
            if c2[i] == 0 {
                n2 += 1;
            }
            c2[i] += 1;
        }
        if n1 < n2 {
            return Solution::is_it_possible(word2, word1);
        }
        if n1 - n2 > 1 {
            return false;
        }
        let mut diff = 0;
        for i in 0..26 {
            if c1[i] > 0 && c2[i] == 0 {
                diff += 1;
            }
        }
        if n1 == n2 {
            return diff <= 2;
        } else {
            return diff <= 1;
        }
    }
}