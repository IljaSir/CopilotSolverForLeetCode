impl Solution {
    pub fn appeal_sum(s: String) -> i64 {
        
        let mut sum = 0;
        let mut count = vec![0; 26];
        let mut n = 0;
        for c in s.chars() {
            if count[(c as u8 - b'a') as usize] == 0 {
                n += 1;
            }
            count[(c as u8 - b'a') as usize] += 1;
            sum += n;
        }
        sum
    }
}