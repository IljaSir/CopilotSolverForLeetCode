impl Solution {
    pub fn equal_frequency(word: String) -> bool {
        
        let mut cnt = [0; 26];
        for c in word.chars() {
            cnt[c as usize - 'a' as usize] += 1;
        }
        let mut freq = [0; 101];
        for i in 0..26 {
            if cnt[i] > 0 {
                freq[cnt[i] as usize] += 1;
            }
        }
        let mut diff = 0;
        let mut i = 0;
        while i < 101 && freq[i] == 0 {
            i += 1;
        }
        let mut j = 100;
        while j > 0 && freq[j] == 0 {
            j -= 1;
        }
        if i == j {
            return true;
        }
        if i + 1 == j && freq[i] == 1 {
            return true;
        }
        if j - i == 1 && freq[j] == 1 {
            return true;
        }
        false
    }
}