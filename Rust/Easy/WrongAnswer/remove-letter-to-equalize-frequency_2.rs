impl Solution {
    pub fn equal_frequency(word: String) -> bool {
        
        let mut freq = vec![0; 26];
        for c in word.chars() {
            freq[c as usize - 'a' as usize] += 1;
        }
        freq.sort();
        let mut i = 0;
        while freq[i] == 0 {
            i += 1;
        }
        let min = freq[i];
        let max = freq[25];
        if min == max {
            return true;
        }
        if min == 1 {
            return freq[i + 1] == max;
        }
        if max - min == 1 {
            return freq[24] == min;
        }
        false
    }
}