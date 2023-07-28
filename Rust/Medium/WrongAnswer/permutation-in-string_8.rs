impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let (mut left, mut right) = (0, 0);
        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let mut windows = [0; 26];
        let mut needs = [0; 26];
        for i in 0..s1.len() {
            needs[s1[i] as usize - 'a' as usize] += 1;
        }
        let mut match_count = 0;
        while right < s2.len() {
            let c = s2[right] as usize - 'a' as usize;
            if needs[c] > 0 {
                windows[c] += 1;
                if windows[c] == needs[c] {
                    match_count += 1;
                }
            }
            right += 1;
            while right - left > s1.len() {
                let c = s2[left] as usize - 'a' as usize;
                if needs[c] > 0 {
                    windows[c] -= 1;
                    if windows[c] < needs[c] {
                        match_count -= 1;
                    }
                }
                left += 1;
            }
            if match_count == needs.len() {
                return true;
            }
        }
        false
    }
}