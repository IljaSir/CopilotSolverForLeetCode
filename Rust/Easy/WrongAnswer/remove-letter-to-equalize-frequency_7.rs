impl Solution {
    pub fn equal_frequency(word: String) -> bool {
        
        let mut cnt = vec![0; 26];
        for c in word.chars() {
            cnt[c as usize - 'a' as usize] += 1;
        }
        let mut cnts = vec![0; word.len() + 1];
        for c in cnt {
            cnts[c] += 1;
        }
        let mut n = 0;
        let mut c = 0;
        for i in 0..=word.len() {
            if cnts[i] > 0 {
                n += 1;
                c = cnts[i];
            }
        }
        if n == 1 {
            true
        } else if n == 2 {
            c == 1 || cnts[0] == 1
        } else {
            false
        }
    }
}