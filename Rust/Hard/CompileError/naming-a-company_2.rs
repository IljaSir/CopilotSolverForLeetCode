impl Solution {
    pub fn distinct_names(ideas: Vec<String>) -> i64 {
        
        let mut names = HashSet::new();
        for i in 0..ideas.len() {
            for j in i+1..ideas.len() {
                let mut ideaA = ideas[i].clone();
                let mut ideaB = ideas[j].clone();
                let mut a = ideaA.chars().nth(0).unwrap();
                let mut b = ideaB.chars().nth(0).unwrap();
                ideaA.replace_range(0..1, &b.to_string());
                ideaB.replace_range(0..1, &a.to_string());
                if !ideas.contains(&ideaA) && !ideas.contains(&ideaB) {
                    names.insert(ideaA + " " + &ideaB);
                }
            }
        }
        names.len() as i64
    }
}