impl Solution {
    pub fn halves_are_alike(s: String) -> bool {
        
        let vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
        let mut count = 0;
        for (i, c) in s.chars().enumerate() {
            if vowels.contains(&c) {
                if i < s.len() / 2 {
                    count += 1;
                } else {
                    count -= 1;
                }
            }
        }
        count == 0
    }
}