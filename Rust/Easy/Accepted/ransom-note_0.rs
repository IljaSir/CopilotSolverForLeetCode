impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        
        let mut count = [0; 26];
        for c in magazine.chars() {
            count[c as usize - 'a' as usize] += 1;
        }
        for c in ransom_note.chars() {
            count[c as usize - 'a' as usize] -= 1;
            if count[c as usize - 'a' as usize] < 0 {
                return false;
            }
        }
        true
    }
}