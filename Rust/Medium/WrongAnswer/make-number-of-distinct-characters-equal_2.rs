impl Solution {
    pub fn is_it_possible(word1: String, word2: String) -> bool {
        
        let mut c1 = vec![0; 26];
        let mut c2 = vec![0; 26];
        for c in word1.chars() {
            c1[(c as u8 - 'a' as u8) as usize] += 1;
        }
        for c in word2.chars() {
            c2[(c as u8 - 'a' as u8) as usize] += 1;
        }
        let mut c3 = vec![0; 26];
        let mut c4 = vec![0; 26];
        for i in 0..26 {
            c3[c1[i] as usize] += 1;
            c4[c2[i] as usize] += 1;
        }
        for i in 0..26 {
            if c3[i] > 0 && c4[i] > 0 {
                c3[i] -= 1;
                c4[i] -= 1;
            }
        }
        let mut s1 = 0;
        let mut s2 = 0;
        for i in 0..26 {
            s1 += c3[i] * i;
            s2 += c4[i] * i;
        }
        if s1 > s2 {
            std::mem::swap(&mut s1, &mut s2);
        }
        s1 == 1 && s2 == 1
    }
}