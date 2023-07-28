impl Solution {
    pub fn is_path_crossing(path: String) -> bool {
        
        let mut x = 0;
        let mut y = 0;
        let mut map = std::collections::HashMap::new();
        map.insert((x, y), 1);
        for c in path.chars() {
            match c {
                'N' => y += 1,
                'S' => y -= 1,
                'E' => x += 1,
                'W' => x -= 1,
                _ => (),
            }
            if map.contains_key(&(x, y)) {
                return true;
            } else {
                map.insert((x, y), 1);
            }
        }
        false
    }
}