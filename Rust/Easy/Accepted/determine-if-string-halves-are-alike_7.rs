impl Solution {
    pub fn halves_are_alike(s: String) -> bool {
        
        let mut count = 0;
        let mut i = 0;
        let mut j = s.len() - 1;
        let mut s = s.chars().collect::<Vec<char>>();
        while i < j {
            count += match s[i] {
                'a' | 'e' | 'i' | 'o' | 'u' | 'A' | 'E' | 'I' | 'O' | 'U' => 1,
                _ => 0,
            };
            count -= match s[j] {
                'a' | 'e' | 'i' | 'o' | 'u' | 'A' | 'E' | 'I' | 'O' | 'U' => 1,
                _ => 0,
            };
            i += 1;
            j -= 1;
        }
        count == 0
    }
}