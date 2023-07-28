impl Solution {
    pub fn min_jumps(arr: Vec<i32>) -> i32 {
        
        let mut last_pos = std::collections::HashMap::new();
        let mut q = std::collections::VecDeque::new();
        let mut visited = std::collections::HashSet::new();
        q.push_back((0, 0));
        visited.insert(0);
        while let Some((idx, step)) = q.pop_front() {
            if idx == arr.len() - 1 {
                return step;
            }
            if let Some(last_idx) = last_pos.get(&arr[idx]) {
                if !visited.contains(last_idx) {
                    q.push_back((*last_idx, step + 1));
                    visited.insert(*last_idx);
                }
            }
            last_pos.insert(arr[idx], idx);
            if idx > 0 && !visited.contains(&(idx - 1)) {
                q.push_back((idx - 1, step + 1));
                visited.insert(idx - 1);
            }
            if idx < arr.len() - 1 && !visited.contains(&(idx + 1)) {
                q.push_back((idx + 1, step + 1));
                visited.insert(idx + 1);
            }
        }
        0
    }
}