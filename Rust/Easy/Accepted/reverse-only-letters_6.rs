impl Solution {
    pub fn reverse_only_letters(s: String) -> String {
        
        let mut v = s.chars().collect::<Vec<char>>();
        let mut i = 0;
        let mut j = v.len() - 1;
        while i < j {
            if !v[i].is_ascii_alphabetic() {
                i += 1;
                continue;
            }
            if !v[j].is_ascii_alphabetic() {
                j -= 1;
                continue;
            }
            v.swap(i, j);
            i += 1;
            j -= 1;
        }
        v.into_iter().collect()
    }
}