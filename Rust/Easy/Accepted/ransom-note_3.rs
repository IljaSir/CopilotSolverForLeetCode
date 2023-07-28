impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        
        let mut ransom_note: Vec<char> = ransom_note.chars().collect();
        let mut magazine: Vec<char> = magazine.chars().collect();
        ransom_note.sort();
        magazine.sort();
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