impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        
        let mut count = [0; 3];
        let mut res = 0;
        let mut j = 0;
        let mut k = 0;
        for (i, c) in s.as_bytes().iter().enumerate() {
            count[*c as usize - 97] += 1;
            while count[0] > 0 && count[1] > 0 && count[2] > 0 {
                count[s.as_bytes()[j] as usize - 97] -= 1;
                j += 1;
            }
            k = i + 1;
            res += k - j;
        }
        res as i32
    }
}