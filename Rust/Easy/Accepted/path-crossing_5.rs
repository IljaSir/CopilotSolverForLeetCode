impl Solution {
    pub fn is_path_crossing(path: String) -> bool {
        
        let mut visited = vec![(0, 0)];
        let mut x = 0;
        let mut y = 0;
        for c in path.chars() {
            match c {
                'N' => y += 1,
                'S' => y -= 1,
                'E' => x += 1,
                'W' => x -= 1,
                _ => (),
            }
            if visited.contains(&(x, y)) {
                return true;
            } else {
                visited.push((x, y));
            }
        }
        false
    }
}