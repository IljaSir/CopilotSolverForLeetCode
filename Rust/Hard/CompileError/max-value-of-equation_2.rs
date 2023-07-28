impl Solution {
    pub fn find_max_value_of_equation(points: Vec<Vec<i32>>, k: i32) -> i32 {
        
        let mut max = i32::MIN;
        let mut queue = std::collections::VecDeque::new();
        for point in points {
            while !queue.is_empty() && point[0] - queue[0][1] > k {
                queue.pop_front();
            }
            if !queue.is_empty() {
                max = max.max(point[0] + point[1] + queue[0][0]);
            }
            while !queue.is_empty() && point[1] - point[0] > queue[queue.len() - 1][0] {
                queue.pop_back();
            }
            queue.push_back((point[1] - point[0], point[0]));
        }
        max
    }
}