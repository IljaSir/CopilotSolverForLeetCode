impl Solution {
    pub fn pyramid_transition(bottom: String, allowed: Vec<String>) -> bool {
        
        let mut map = std::collections::HashMap::new();
        for s in allowed {
            let mut chars = s.chars();
            let c1 = chars.next().unwrap();
            let c2 = chars.next().unwrap();
            let c3 = chars.next().unwrap();
            map.entry((c1, c2)).or_insert(Vec::new()).push(c3);
        }
        let mut bottom = bottom.chars().collect::<Vec<_>>();
        let mut top = Vec::new();
        for _ in 0..bottom.len() - 1 {
            top.push(' ');
        }
        Self::dfs(&bottom, &mut top, &map)
    }
    fn dfs(bottom: &[char], top: &mut [char], map: &std::collections::HashMap<(char, char), Vec<char>>) -> bool {
        if bottom.len() == 1 {
            return true;
        }
        if top.len() == 1 {
            return Self::dfs(top, bottom, map);
        }
        let c1 = bottom[0];
        let c2 = bottom[1];
        if let Some(v) = map.get(&(c1, c2)) {
            for &c3 in v {
                top[0] = c3;
                if Self::dfs(bottom, top, map) {
                    return true;
                }
            }
        }
        false
    }
}