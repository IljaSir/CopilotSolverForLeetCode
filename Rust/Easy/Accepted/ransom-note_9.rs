impl Solution {
    pub fn can_construct(ransom_note: String, magazine: String) -> bool {
        
        let mut mag = magazine.chars().collect::<Vec<char>>();
        for c in ransom_note.chars() {
            match mag.iter().position(|&x| x == c) {
                Some(i) => { mag.remove(i); },
                None => { return false; },
            }
        }
        true
    }
}