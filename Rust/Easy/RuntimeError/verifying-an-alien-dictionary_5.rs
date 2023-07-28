impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let order = order.chars().collect::<Vec<char>>();
        let mut words = words.into_iter().map(|w| w.chars().collect::<Vec<char>>()).collect::<Vec<Vec<char>>>();
        for i in 0..words.len() {
            for j in i+1..words.len() {
                let mut i = 0;
                let mut j = 0;
                while i < words[i].len() && j < words[j].len() {
                    let a = words[i][i];
                    let b = words[j][j];
                    if a != b {
                        let a = order.iter().position(|&x| x == a).unwrap();
                        let b = order.iter().position(|&x| x == b).unwrap();
                        if a > b {
                            return false;
                        } else {
                            break;
                        }
                    }
                    i += 1;
                    j += 1;
                }
                if i < words[i].len() {
                    return false;
                }
            }
        }
        true
    }
}