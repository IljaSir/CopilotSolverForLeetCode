impl Solution {
    pub fn reverse_only_letters(s: String) -> String {
        
        let mut res: Vec<char> = s.chars().collect();
        let mut i = 0;
        let mut j = res.len() - 1;
        while i < j {
            if !res[i].is_ascii_alphabetic() {
                i += 1;
            } else if !res[j].is_ascii_alphabetic() {
                j -= 1;
            } else {
                res.swap(i, j);
                i += 1;
                j -= 1;
            }
        }
        res.iter().collect()
    }
}