impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let order = order.into_bytes();
        let mut map = vec![0; 26];
        for (i, c) in order.iter().enumerate() {
            map[*c as usize - 97] = i;
        }
        let mut words = words.iter().map(|w| {
            w.as_bytes().iter().map(|c| {
                map[*c as usize - 97]
            }).collect::<Vec<usize>>()
        }).collect::<Vec<Vec<usize>>>();
        for i in 1..words.len() {
            if words[i] < words[i - 1] {
                return false;
            }
        }
        true
    }
}