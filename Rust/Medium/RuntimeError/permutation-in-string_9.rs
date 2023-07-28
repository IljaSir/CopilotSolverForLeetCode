impl Solution {
    pub fn check_inclusion(s1: String, s2: String) -> bool {
        

        let mut s1 = s1.into_bytes();
        let mut s2 = s2.into_bytes();
        let mut count = vec![0; 26];
        let mut count2 = vec![0; 26];
        let mut i = 0;
        while i < s1.len() {
            count[s1[i] as usize - 97] += 1;
            count2[s2[i] as usize - 97] += 1;
            i += 1;
        }
        if count == count2 {
            return true;
        }
        while i < s2.len() {
            count2[s2[i - s1.len()] as usize - 97] -= 1;
            count2[s2[i] as usize - 97] += 1;
            if count == count2 {
                return true;
            }
            i += 1;
        }
        false
    }
}