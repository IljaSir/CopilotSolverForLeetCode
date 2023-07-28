impl Solution {
    pub fn equal_frequency(word: String) -> bool {
        
        let mut freq = vec![0; 26];
        for c in word.chars() {
            freq[(c as u8 - b'a') as usize] += 1;
        }
        let mut cnt = vec![0; word.len() + 1];
        for f in freq.iter() {
            if *f > 0 {
                cnt[*f] += 1;
            }
        }
        let mut one = 0;
        let mut more = 0;
        for (i, c) in cnt.iter().enumerate() {
            if *c == 1 {
                one = i;
            }
            if *c > 1 {
                more = i;
            }
        }
        if one == 0 {
            return true;
        }
        if one == 1 {
            return more == 1 || more == word.len();
        } else if one == more - 1 {
            return cnt[one] == 1;
        }
        false
    }
}