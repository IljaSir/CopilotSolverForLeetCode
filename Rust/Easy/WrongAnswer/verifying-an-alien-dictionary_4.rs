impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let mut map = [0;26];
        for (i, c) in order.chars().enumerate() {
            map[c as usize - 'a' as usize] = i;
        }
        for i in 0..words.len()-1 {
            let mut j = 0;
            while j < words[i].len() && j < words[i+1].len() {
                if words[i].chars().nth(j).unwrap() != words[i+1].chars().nth(j).unwrap() {
                    if map[words[i].chars().nth(j).unwrap() as usize - 'a' as usize] > map[words[i+1].chars().nth(j).unwrap() as usize - 'a' as usize] {
                        return false;
                    }
                    break;
                }
                j += 1;
            }
            if j == words[i].len() && j < words[i+1].len() {
                return false;
            }
        }
        true
    }
}