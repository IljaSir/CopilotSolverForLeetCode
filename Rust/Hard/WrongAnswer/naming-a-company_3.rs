impl Solution {
    pub fn distinct_names(ideas: Vec<String>) -> i64 {
        
        let mut res = 0;
        let mut set = std::collections::HashSet::new();
        let mut vec = vec![];
        for i in 0..ideas.len() {
            let mut s = ideas[i].clone();
            for j in i+1..ideas.len() {
                let mut s1 = s.clone();
                let mut s2 = ideas[j].clone();
                let c1 = s1.remove(0);
                let c2 = s2.remove(0);
                s1.insert(0, c2);
                s2.insert(0, c1);
                if !set.contains(&s1) && !set.contains(&s2) {
                    res += 1;
                    vec.push(s1);
                    vec.push(s2);
                }
            }
            set.insert(s);
        }
        for s in vec {
            set.insert(s);
        }
        res + set.len() as i64
    }
}