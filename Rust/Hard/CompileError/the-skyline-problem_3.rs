impl Solution {
    pub fn get_skyline(buildings: Vec<Vec<i32>>) -> Vec<Vec<i32>> {
        
        let mut skyline = Vec::new();
        let mut heights = Vec::new();
        for b in buildings {
            heights.push((b[0], -b[2]));
            heights.push((b[1], b[2]));
        }
        heights.sort();
        let mut pq = std::collections::BinaryHeap::new();
        let mut prev = 0;
        pq.push(0);
        for h in heights {
            if h.1 < 0 {
                pq.push(-h.1);
            } else {
                pq.retain(|&x| x != h.1);
            }
            let cur = *pq.peek().unwrap();
            if cur != prev {
                skyline.push(vec![h.0, cur]);
                prev = cur;
            }
        }
        skyline
    }
}