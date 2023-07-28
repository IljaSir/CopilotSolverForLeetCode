impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut count = [0; 26];
        for c in s.bytes() {
            count[(c - b'a') as usize] += 1;
        }
        let mut min = 1001;
        let mut max = 0;
        for &c in count.iter() {
            if c == 0 {
                continue;
            }
            if c < min {
                min = c;
            }
            if c > max {
                max = c;
            }
        }
        min == max
    }
}