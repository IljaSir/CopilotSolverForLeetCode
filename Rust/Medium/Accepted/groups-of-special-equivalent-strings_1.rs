impl Solution {
    pub fn num_special_equiv_groups(words: Vec<String>) -> i32 {
        
        let mut set = std::collections::HashSet::new();
        for word in words {
            let mut odd = vec![];
            let mut even = vec![];
            for (i, c) in word.chars().enumerate() {
                if i % 2 == 0 {
                    even.push(c);
                } else {
                    odd.push(c);
                }
            }
            even.sort();
            odd.sort();
            set.insert((even, odd));
        }
        set.len() as i32
    }
}