impl Solution {
    pub fn equal_frequency(word: String) -> bool {
        
        let mut freq = vec![0; 26];
        for c in word.bytes() {
            freq[(c - b'a') as usize] += 1;
        }
        let mut count = 0;
        for i in 0..26 {
            if freq[i] > 0 {
                count += 1;
            }
        }
        if count == 1 {
            return true;
        }
        for i in 0..26 {
            if freq[i] == 0 {
                continue;
            }
            freq[i] -= 1;
            let mut f = 0;
            for j in 0..26 {
                if freq[j] > 0 {
                    f = gcd(f, freq[j]);
                }
            }
            if f > 1 {
                return true;
            }
            freq[i] += 1;
        }
        false
    }
}