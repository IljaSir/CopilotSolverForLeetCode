impl Solution {
    pub fn get_skyline(buildings: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut b = buildings;
        let mut res = Vec::new();
        b.sort_by(|a, b| a[0].cmp(&b[0]));
        let mut pq = std::collections::BinaryHeap::new();
        pq.push((0, std::i32::MAX));
        let mut prev = 0;
        for i in 0..b.len() {
            let left = b[i][0];
            let right = b[i][1];
            let height = b[i][2];
            while pq.peek().unwrap().1 <= left {
                pq.pop();
            }
            if height > pq.peek().unwrap().0 {
                if prev != height {
                    res.push(vec![left, height]);
                    prev = height;
                }
            }
            pq.push((height, right));
        }
        while !pq.is_empty() {
            let p = pq.pop().unwrap();
            let h = p.0;
            let r = p.1;
            if prev != 0 {
                res.push(vec![r, 0]);
                prev = 0;
            }
        }
        res
    }
}