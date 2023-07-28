impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        
        let mut char_count = [0; 26];
        for c in magazine.chars() {
            char_count[c as usize - 97] += 1;
        }
        for c in ransom_note.chars() {
            if char_count[c as usize - 97] == 0 {
                return false;
            }
            char_count[c as usize - 97] -= 1;
        }
        true
    }
}