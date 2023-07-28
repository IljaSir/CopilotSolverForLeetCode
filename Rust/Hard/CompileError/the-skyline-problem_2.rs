impl Solution {
    pub fn get_skyline(buildings: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut ans = vec![];
        let mut points = vec![];
        for b in buildings {
            points.push((b[0], -b[2]));
            points.push((b[1], b[2]));
        }
        points.sort();
        let mut heap = std::collections::BinaryHeap::new();
        heap.push(0);
        let mut height = 0;
        for (x, y) in points {
            if y < 0 {
                heap.push(-y);
            } else {
                heap.retain(|&h| h != y);
            }
            let h = *heap.peek().unwrap();
            if h != height {
                ans.push(vec![x, h]);
                height = h;
            }
        }
        ans
    }
}