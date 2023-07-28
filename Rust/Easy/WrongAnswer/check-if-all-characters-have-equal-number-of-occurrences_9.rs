impl Solution {
    pub fn are_occurrences_equal(s: String) -> bool {
        
        let mut count = vec![0;26];
        for ch in s.chars() {
            count[ch as usize - 'a' as usize] += 1;
        }
        let mut flag = true;
        for i in 1..count.len() {
            if count[i] != count[i-1] && count[i] != 0 {
                flag = false;
                break;
            }
        }
        flag
    }
}