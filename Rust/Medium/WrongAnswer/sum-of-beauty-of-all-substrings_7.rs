impl Solution {
    pub fn beauty_sum(s: String) -> i32 {
        
        let mut sum = 0;
        let s = s.as_bytes();
        let mut freq = vec![0; 26];
        for i in 0..s.len() {
            freq[(s[i] - b'a') as usize] += 1;
            let mut min = i32::max_value();
            let mut max = i32::min_value();
            for j in 0..26 {
                if freq[j] != 0 {
                    min = min.min(freq[j] as i32);
                    max = max.max(freq[j] as i32);
                }
            }
            sum += max - min;
        }
        sum
    }
}