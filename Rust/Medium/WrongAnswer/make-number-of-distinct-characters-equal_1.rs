impl Solution {
    pub fn is_it_possible(word1: String, word2: String) -> bool {
        
        let mut freq1 = vec![0; 26];
        let mut freq2 = vec![0; 26];
        for c in word1.chars() {
            freq1[c as usize - 'a' as usize] += 1;
        }
        for c in word2.chars() {
            freq2[c as usize - 'a' as usize] += 1;
        }
        let mut diff1 = 0;
        let mut diff2 = 0;
        for i in 0..26 {
            if freq1[i] > 0 && freq2[i] == 0 {
                diff1 += 1;
            }
            if freq1[i] == 0 && freq2[i] > 0 {
                diff2 += 1;
            }
        }
        if diff1 == 0 && diff2 == 0 {
            return false;
        }
        if diff1 + diff2 <= 2 {
            return true;
        }
        let mut sum1 = 0;
        let mut sum2 = 0;
        for i in 0..26 {
            sum1 += freq1[i];
            sum2 += freq2[i];
        }
        sum1 > sum2
    }
}