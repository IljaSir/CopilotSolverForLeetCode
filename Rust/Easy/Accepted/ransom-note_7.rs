impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        
        let mut map = vec![0; 26];
        for c in magazine.chars() {
            let idx = c as usize - 'a' as usize;
            map[idx] += 1;
        }
        for c in ransom_note.chars() {
            let idx = c as usize - 'a' as usize;
            map[idx] -= 1;
            if map[idx] < 0 {
                return false;
            }
        }
        true
    }
}