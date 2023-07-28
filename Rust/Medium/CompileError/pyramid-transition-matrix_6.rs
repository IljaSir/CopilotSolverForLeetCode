impl Solution {
    pub fn pyramid_transition(bottom: String, allowed: Vec<String>) -> bool {
        
        let mut m: HashMap<(char, char), Vec<char>> = HashMap::new();
        for s in allowed {
            let mut it = s.chars();
            let c1 = it.next().unwrap();
            let c2 = it.next().unwrap();
            let c3 = it.next().unwrap();
            m.entry((c1, c2)).or_insert(vec![]).push(c3);
        }
        let mut v: Vec<char> = bottom.chars().collect();
        Self::dfs(&mut v, &m)
    }
    fn dfs(v: &mut Vec<char>, m: &HashMap<(char, char), Vec<char>>) -> bool {
        let n = v.len();
        if n == 1 {
            return true;
        }
        let mut v2 = vec![];
        for i in 0..n-1 {
            let c1 = v[i];
            let c2 = v[i+1];
            if let Some(v3) = m.get(&(c1, c2)) {
                v2.extend(v3.iter().map(|&c| c));
            } else {
                return false;
            }
        }
        Self::dfs(&mut v2, m)
    }
}