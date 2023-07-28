impl Solution {
    pub fn find_max_value_of_equation(points: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let mut max = std::i32::MIN;
        let mut q = std::collections::BinaryHeap::new();
        for p in points {
            while let Some(&[x, y]) = q.peek() {
                if p[0] - x <= k {
                    max = max.max(p[0] + p[1] + y);
                    break;
                } else {
                    q.pop();
                }
            }
            q.push([p[0], p[1] - p[0]]);
        }
        max
    }
}