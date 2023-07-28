impl Solution {
    pub fn distinct_names(ideas: Vec<String>) -> i64 {
        
        let mut res = 0;
        let mut set = std::collections::HashSet::new();
        for i in 0..ideas.len() {
            for j in i+1..ideas.len() {
                let mut a = ideas[i].clone();
                let mut b = ideas[j].clone();
                let tmp = a.as_bytes()[0];
                a.as_bytes_mut()[0] = b.as_bytes()[0];
                b.as_bytes_mut()[0] = tmp;
                if !set.contains(&a) && !set.contains(&b) {
                    res += 1;
                    set.insert(a);
                    set.insert(b);
                }
            }
        }
        res
    }
}