impl Solution {
    pub fn num_special_equiv_groups(words: Vec<String>) -> i32 {
        
        let mut s = std::collections::HashSet::new();
        for w in words {
            let mut a = [0; 52];
            for (i, c) in w.as_bytes().iter().enumerate() {
                a[*c as usize - 97 + 26 * (i % 2)] += 1;
            }
            s.insert(a);
        }
        s.len() as i32
    }
}