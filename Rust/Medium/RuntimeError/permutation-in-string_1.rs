impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let s1 = s1.as_bytes();
        let s2 = s2.as_bytes();
        let mut s1_map = [0; 26];
        let mut s2_map = [0; 26];
        for i in 0..s1.len() {
            s1_map[(s1[i] - b'a') as usize] += 1;
            s2_map[(s2[i] - b'a') as usize] += 1;
        }
        for i in 0..s2.len() - s1.len() {
            if s1_map == s2_map {
                return true;
            }
            s2_map[(s2[i] - b'a') as usize] -= 1;
            s2_map[(s2[i + s1.len()] - b'a') as usize] += 1;
        }
        s1_map == s2_map
    }
}