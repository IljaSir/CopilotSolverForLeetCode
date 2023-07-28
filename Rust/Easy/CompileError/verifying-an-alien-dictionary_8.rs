impl Solution {
    pub fn is_alien_sorted(words: Vec<String>, order: String) -> bool {
        
        let mut order = order.chars().collect::<Vec<char>>();
        let mut words = words;
        words.sort_by(|a, b| {
            let mut i = 0;
            let mut j = 0;
            while i < a.len() && j < b.len() {
                if order.iter().position(|x| *x == a.chars().nth(i).unwrap()).unwrap() < order.iter().position(|x| *x == b.chars().nth(j).unwrap()).unwrap() {
                    return Ordering::Less;
                }
                if order.iter().position(|x| *x == a.chars().nth(i).unwrap()).unwrap() > order.iter().position(|x| *x == b.chars().nth(j).unwrap()).unwrap() {
                    return Ordering::Greater;
                }
                i += 1;
                j += 1;
            }
            if i == a.len() && j == b.len() {
                return Ordering::Equal;
            }
            if i == a.len() {
                return Ordering::Less;
            }
            return Ordering::Greater;
        });
        for i in 0..words.len() - 1 {
            if words[i] > words[i + 1] {
                return false;
            }
        }
        return true;
    }
}