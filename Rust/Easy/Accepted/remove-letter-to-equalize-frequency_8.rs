impl Solution {
    pub fn equal_frequency(word: String) -> bool {
        
        let mut freq = [0;26];
        for c in word.chars() {
            freq[c as usize - 97] += 1;
        }
        let mut count = 0;
        for i in 0..26 {
            if freq[i] != 0 {
                count += 1;
            }
        }
        if count == 1 {
            return true;
        }
        let mut freqs = freq.to_vec();
        freqs.sort();
        let mut i = 0;
        while i < 26 && freqs[i] == 0 {
            i += 1;
        }
        let mut j = 25;
        while j >= 0 && freqs[j] == 0 {
            j -= 1;
        }
        if freqs[i] == 1 && freqs[i+1] == freqs[j] {
            return true;
        }
        if freqs[j] - freqs[i] == 1 && freqs[j-1] == freqs[i] {
            return true;
        }
        false
    }
}