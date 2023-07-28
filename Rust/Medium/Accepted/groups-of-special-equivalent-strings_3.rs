impl Solution {
    pub fn num_special_equiv_groups(words: Vec<String>) -> i32 {
        
        let mut groups = vec![];
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
            let group = (even, odd);
            if groups.contains(&group) {
                continue;
            } else {
                groups.push(group);
            }
        }
        groups.len() as i32
    }
}