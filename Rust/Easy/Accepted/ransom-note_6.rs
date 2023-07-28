impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        
        let mut magazine = magazine.chars().collect::<Vec<_>>();
        for c in ransom_note.chars() {
            if let Some(i) = magazine.iter().position(|&x| x == c) {
                magazine.remove(i);
            } else {
                return false;
            }
        }
        true
    }
}