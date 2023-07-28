impl Solution {
    pub fn is_it_possible(word1: String, word2: String) -> bool {
        
        let mut count1 = vec![0; 26];
        let mut count2 = vec![0; 26];
        let mut diff = 0;
        for i in 0..word1.len() {
            if word1[i..i+1] != word2[i..i+1] {
                diff += 1;
            }
            count1[(word1[i..i+1].chars().next().unwrap() as u8 - 'a' as u8) as usize] += 1;
            count2[(word2[i..i+1].chars().next().unwrap() as u8 - 'a' as u8) as usize] += 1;
        }
        if diff > 2 {
            return false;
        }
        let mut count = 0;
        for i in 0..26 {
            if count1[i] > 0 && count2[i] > 0 {
                count += 1;
            }
        }
        if diff == 1 {
            return count > 1;
        }
        if diff == 2 {
            return count > 0;
        }
        return count > 1;
    }
}