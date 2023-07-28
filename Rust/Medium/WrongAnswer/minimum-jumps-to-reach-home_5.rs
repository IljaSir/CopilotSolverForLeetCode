impl Solution {
    pub fn minimum_jumps(forbidden: Vec<i32>, a: i32, b: i32, x: i32) -> i32 {
        
        let mut queue = std::collections::VecDeque::new();
        let mut visited = std::collections::HashSet::new();
        let mut forbidden = forbidden;
        forbidden.sort();
        queue.push_back((0, false));
        visited.insert((0, false));
        let mut steps = 0;
        while !queue.is_empty() {
            let mut size = queue.len();
            while size > 0 {
                let (pos, is_back) = queue.pop_front().unwrap();
                if pos == x {
                    return steps;
                }
                if !is_back && pos + a <= 6000 && !forbidden.contains(&(pos + a)) {
                    let next = (pos + a, false);
                    if !visited.contains(&next) {
                        queue.push_back(next);
                        visited.insert(next);
                    }
                }
                if pos - b >= 0 && !forbidden.contains(&(pos - b)) {
                    let next = (pos - b, true);
                    if !visited.contains(&next) {
                        queue.push_back(next);
                        visited.insert(next);
                    }
                }
                size -= 1;
            }
            steps += 1;
        }
        -1
    }
}