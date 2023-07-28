impl Solution {
    pub fn find_max_value_of_equation(points: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let mut q = std::collections::VecDeque::new();
        let mut max = std::i32::MIN;
        for p in points {
            while !q.is_empty() && p[0] - q.front().unwrap()[1] > k {
                q.pop_front();
            }
            if !q.is_empty() {
                max = max.max(q.front().unwrap()[0] + p[0] + p[1]);
            }
            while !q.is_empty() && q.back().unwrap()[0] <= p[1] - p[0] {
                q.pop_back();
            }
            q.push_back([p[1] - p[0], p[0]]);
        }
        max
    }
}