impl Solution {
    pub fn get_skyline(buildings: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut res = vec![];
        let mut height = vec![];
        for b in buildings {
            height.push((b[0], -b[2]));
            height.push((b[1], b[2]));
        }
        height.sort();
        let mut pq = std::collections::BinaryHeap::new();
        pq.push(0);
        let mut pre = 0;
        for h in height {
            if h.1 < 0 {
                pq.push(-h.1);
            } else {
                pq.remove(&h.1);
            }
            let cur = *pq.peek().unwrap();
            if cur != pre {
                res.push(vec![h.0, cur]);
                pre = cur;
            }
        }
        res
    }
}