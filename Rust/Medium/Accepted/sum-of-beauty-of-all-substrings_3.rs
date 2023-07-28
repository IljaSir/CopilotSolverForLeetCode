impl Solution {
    pub fn beauty_sum(s: String) -> i32 {
        
        let mut sum = 0;
        let bytes = s.as_bytes();
        for i in 0..bytes.len() {
            let mut freq = [0; 26];
            for j in i..bytes.len() {
                freq[(bytes[j] - b'a') as usize] += 1;
                let mut min = 500;
                let mut max = 0;
                for k in 0..26 {
                    if freq[k] > 0 {
                        min = min.min(freq[k]);
                        max = max.max(freq[k]);
                    }
                }
                sum += max - min;
            }
        }
        sum
    }
}