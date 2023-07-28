impl Solution {
    pub fn pyramid_transition(bottom: String, allowed: Vec<String>) -> bool {
        
        let mut map: Vec<Vec<Vec<char>>> = vec![vec![vec![]; 7]; 7];
        for s in allowed {
            let chars: Vec<char> = s.chars().collect();
            map[(chars[0] as usize) - 65][(chars[1] as usize) - 65].push(chars[2]);
        }
        let mut stack: Vec<(usize, usize)> = Vec::new();
        let mut top = 0;
        let mut bottom = bottom.chars().collect::<Vec<char>>();
        while bottom.len() > 1 {
            stack.clear();
            top = 0;
            for i in 0..bottom.len() - 1 {
                stack.push((bottom[i] as usize - 65, bottom[i + 1] as usize - 65));
            }
            bottom.clear();
            for i in 0..stack.len() {
                if map[stack[i].0][stack[i].1].len() == 0 {
                    return false;
                }
                if top < map[stack[i].0][stack[i].1].len() {
                    bottom.push(map[stack[i].0][stack[i].1][top]);
                } else {
                    top = 0;
                    bottom.push(map[stack[i].0][stack[i].1][top]);
                }
                top += 1;
            }
        }
        true
    }
}