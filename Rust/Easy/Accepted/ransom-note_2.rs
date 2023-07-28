impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        
        let mut map: Vec<i32> = vec![0; 26];
        for c in magazine.chars() {
            map[c as usize - 'a' as usize] += 1;
        }
        for c in ransom_note.chars() {
            map[c as usize - 'a' as usize] -= 1;
            if map[c as usize - 'a' as usize] < 0 {
                return false;
            }
        }
        true
    }
}