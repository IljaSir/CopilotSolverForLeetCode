impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let mut s1_map = [0; 26];
        let mut s2_map = [0; 26];
        let s1_len = s1.len();
        let s2_len = s2.len();
        if s1_len > s2_len {
            return false;
        }
        for i in 0..s1_len {
            s1_map[(s1[i] - b'a') as usize] += 1;
            s2_map[(s2[i] - b'a') as usize] += 1;
        }
        if s1_map == s2_map {
            return true;
        }
        let mut i = 0;
        while i + s1_len < s2_len {
            s2_map[(s2[i] - b'a') as usize] -= 1;
            s2_map[(s2[i + s1_len] - b'a') as usize] += 1;
            if s1_map == s2_map {
                return true;
            }
            i += 1;
        }
        false
    }
}