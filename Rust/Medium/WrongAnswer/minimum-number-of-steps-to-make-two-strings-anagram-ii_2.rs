impl Solution {
    pub fn min_steps(s: String, t: String) -> i32 {
        
        let mut freq = vec![0; 26];
        for c in s.chars() {
            freq[c as usize - 'a' as usize] += 1;
        }
        for c in t.chars() {
            freq[c as usize - 'a' as usize] -= 1;
        }
        let mut steps = 0;
        for i in 0..26 {
            if freq[i] > 0 {
                steps += freq[i];
            }
        }
        steps
    }
}