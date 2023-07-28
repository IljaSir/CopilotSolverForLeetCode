impl Solution {
    pub fn rearrange_characters(s: String, target: String) -> i32 {
        
        let mut s = s.chars().collect::<Vec<char>>();
        s.sort();
        let mut target = target.chars().collect::<Vec<char>>();
        target.sort();
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while i < s.len() && j < target.len() {
            if s[i] == target[j] {
                i += 1;
                j += 1;
                if j == target.len() {
                    count += 1;
                    j = 0;
                }
            } else {
                i += 1;
            }
        }
        if j == 0 {
            count
        } else {
            0
        }
    }
}