impl Solution {
    pub fn pyramid_transition(bottom: String, allowed: Vec<String>) -> bool {
        
        let mut map: HashMap<(char, char), Vec<char>> = HashMap::new();
        for s in allowed {
            let mut chars = s.chars();
            let c1 = chars.next().unwrap();
            let c2 = chars.next().unwrap();
            let c3 = chars.next().unwrap();
            map.entry((c1, c2)).or_insert(vec![]).push(c3);
        }
        Self::dfs(bottom, &map)
    }
    fn dfs(s: String, map: &HashMap<(char, char), Vec<char>>) -> bool {
        if s.len() == 1 {
            true
        } else {
            let mut res = false;
            for i in 0..s.len() - 1 {
                if !map.contains_key(&(s.chars().nth(i).unwrap(), s.chars().nth(i + 1).unwrap())) {
                    return false;
                }
            }
            for i in 0..s.len() - 1 {
                for &c in map.get(&(s.chars().nth(i).unwrap(), s.chars().nth(i + 1).unwrap())).unwrap() {
                    let mut s2 = s.clone();
                    s2.remove(i);
                    s2.insert(i, c);
                    res |= Self::dfs(s2, map);
                }
            }
            res
        }
    }
}