impl Solution {
    pub fn repeated_character(s: String) -> char {
        
        let mut a = s.chars().collect::<Vec<_>>();
        let mut b = a.clone();
        a.sort();
        b.sort();
        b.reverse();
        for i in 0..a.len()-1 {
            if a[i] == a[i+1] {
                return a[i];
            }
        }
        return b[0];
    }
}