impl Solution {
    pub fn number_of_substrings(s: String) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        let mut res = 0;
        let mut count = vec![0; 3];
        while right < s.len() {
            count[(s.as_bytes()[right] - b'a') as usize] += 1;
            while count[0] > 0 && count[1] > 0 && count[2] > 0 {
                count[(s.as_bytes()[left] - b'a') as usize] -= 1;
                left += 1;
            }
            res += left;
            right += 1;
        }
        res as i32
    }
}