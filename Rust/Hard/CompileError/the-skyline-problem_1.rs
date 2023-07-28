impl Solution {
    pub fn get_skyline(buildings: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut points = vec![];
        for b in buildings {
            points.push((b[0], -b[2]));
            points.push((b[1], b[2]));
        }
        points.sort();
        let mut hq = std::collections::BinaryHeap::new();
        hq.push(0);
        let mut prev = 0;
        for (x, h) in points {
            if h < 0 {
                hq.push(-h);
            } else {
                hq.remove(&h);
            }
            let cur = *hq.peek().unwrap();
            if cur != prev {
                res.push(vec![x, cur]);
                prev = cur;
            }
        }
        res
    }
}