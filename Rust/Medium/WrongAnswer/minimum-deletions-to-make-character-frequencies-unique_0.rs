impl Solution {
    pub fn min_deletions(s: String) -> i32 {
        
        let mut freq = vec![0; 26];
        for c in s.chars() {
            freq[(c as u8 - 'a' as u8) as usize] += 1;
        }
        freq.sort();
        let mut ans = 0;
        let mut prev = 0;
        for i in (0..26).rev() {
            if freq[i] == 0 {
                break;
            }
            if freq[i] > prev {
                prev = freq[i];
            } else {
                ans += prev - freq[i];
                prev -= 1;
                if prev == 0 {
                    prev = 1;
                }
            }
        }
        ans
    }
}