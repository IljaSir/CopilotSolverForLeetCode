impl Solution {
    pub fn minimum_jumps(forbidden: Vec<i32>, a: i32, b: i32, x: i32) -> i32 {
        
        let mut forbidden = forbidden;
        forbidden.sort();
        let mut visited = vec![false; 6000];
        for &v in forbidden.iter() {
            visited[v as usize] = true;
        }
        let mut q = std::collections::VecDeque::new();
        q.push_back((0, false));
        let mut ans = 0;
        while !q.is_empty() {
            let size = q.len();
            for _ in 0..size {
                let (pos, back) = q.pop_front().unwrap();
                if pos == x {
                    return ans;
                }
                if pos + a < 6000 && !visited[(pos + a) as usize] {
                    visited[(pos + a) as usize] = true;
                    q.push_back((pos + a, false));
                }
                if !back && pos - b >= 0 && !visited[(pos - b) as usize] {
                    visited[(pos - b) as usize] = true;
                    q.push_back((pos - b, true));
                }
            }
            ans += 1;
        }
        -1
    }
}