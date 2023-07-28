impl Solution {
    pub fn rearrange_characters(s: String, target: String) -> i32 {
        
        let mut s = s.into_bytes();
        let target = target.into_bytes();
        let mut i = 0;
        let mut j = 0;
        let mut found = false;
        let mut count = 0;
        while i < s.len() {
            if s[i] == target[j] {
                s.swap(i, j);
                j += 1;
                found = true;
                if j == target.len() {
                    j = 0;
                    count += 1;
                }
            }
            i += 1;
        }
        if !found {
            return 0;
        }
        if j != 0 {
            return -1;
        }
        count
    }
}