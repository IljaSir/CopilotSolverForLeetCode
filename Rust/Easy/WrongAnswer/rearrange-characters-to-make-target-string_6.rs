impl Solution {
    pub fn rearrange_characters(s: String, target: String) -> i32 {
        
        let mut s = s.chars().collect::<Vec<char>>();
        let mut target = target.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = 0;
        let mut count = 0;
        while j < target.len() {
            if i >= s.len() {
                return 0;
            }
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
        count
    }
}