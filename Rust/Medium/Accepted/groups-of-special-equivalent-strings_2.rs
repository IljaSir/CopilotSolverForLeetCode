impl Solution {
    pub fn num_special_equiv_groups(words: Vec<String>) -> i32 {
        
        let mut groups = Vec::new();
        for word in words {
            let mut odd = Vec::new();
            let mut even = Vec::new();
            for (i, c) in word.chars().enumerate() {
                if i % 2 == 0 {
                    even.push(c);
                } else {
                    odd.push(c);
                }
            }
            even.sort();
            odd.sort();
            let mut group = even;
            group.append(&mut odd);
            if !groups.contains(&group) {
                groups.push(group);
            }
        }
        groups.len() as i32
    }
}