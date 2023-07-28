impl Solution {
    pub fn halves_are_alike(s: String) -> bool {
        
        let mut a = 0;
        let mut b = 0;
        let vowels = ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'];
        for i in 0..s.len() {
            if vowels.contains(&s.chars().nth(i).unwrap()) {
                if i < s.len() / 2 {
                    a += 1;
                } else {
                    b += 1;
                }
            }
        }
        a == b
    }
}