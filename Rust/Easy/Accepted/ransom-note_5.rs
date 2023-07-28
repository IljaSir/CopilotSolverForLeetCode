impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        
        let mut ransom_note = ransom_note.into_bytes();
        let mut magazine = magazine.into_bytes();
        ransom_note.sort_unstable();
        magazine.sort_unstable();
        let mut i = 0;
        let mut j = 0;
        while i < ransom_note.len() && j < magazine.len() {
            if ransom_note[i] == magazine[j] {
                i += 1;
                j += 1;
            } else if ransom_note[i] < magazine[j] {
                return false;
            } else {
                j += 1;
            }
        }
        i == ransom_note.len()
    }
}