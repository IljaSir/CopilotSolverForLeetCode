impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let mut cnt = [0; 26];
        for &c in s1 {
            cnt[c as usize - 'a' as usize] += 1;
        }
        let mut i = 0;
        let mut j = 0;
        while j < s2.len() {
            let c = s2[j] as usize - 'a' as usize;
            cnt[c] -= 1;
            while cnt[c] < 0 {
                cnt[s2[i] as usize - 'a' as usize] += 1;
                i += 1;
            }
            if j - i + 1 == s1.len() {
                return true;
            }
            j += 1;
        }
        false
    }
}