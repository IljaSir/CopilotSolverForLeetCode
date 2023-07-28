impl Solution {
    pub fn halves_are_alike(s: String) -> bool {
        
        let mut count = 0;
        let mut chars = s.chars();
        for _ in 0..s.len()/2 {
            match chars.next().unwrap() {
                'a'|'e'|'i'|'o'|'u'|'A'|'E'|'I'|'O'|'U' => count += 1,
                _ => count -= 1
            }
            match chars.next_back().unwrap() {
                'a'|'e'|'i'|'o'|'u'|'A'|'E'|'I'|'O'|'U' => count += 1,
                _ => count -= 1
            }
        }
        return count == 0;
    }
}