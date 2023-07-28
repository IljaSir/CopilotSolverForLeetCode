impl Solution {
    pub fn get_skyline(buildings: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut points = Vec::new();
        for b in buildings {
            points.push((b[0], -b[2]));
            points.push((b[1], b[2]));
        }
        points.sort();
        let mut heights = std::collections::BinaryHeap::new();
        let mut res = Vec::new();
        let mut prev = 0;
        heights.push(0);
        for p in points {
            if p.1 < 0 {
                heights.push(-p.1);
            } else {
                heights.remove(&p.1);
            }
            let cur = *heights.peek().unwrap();
            if cur != prev {
                res.push(vec![p.0, cur]);
                prev = cur;
            }
        }
        res
    }
}