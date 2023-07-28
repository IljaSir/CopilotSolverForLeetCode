impl Solution {
    pub fn furthest_building(heights: Vec<i32>, bricks: i32, ladders: i32) -> i32 {
        
        let mut bricks = bricks;
        let mut ladders = ladders;
        let mut pq = std::collections::BinaryHeap::new();
        for i in 0..heights.len() - 1 {
            let diff = heights[i + 1] - heights[i];
            if diff > 0 {
                pq.push(diff);
                if pq.len() > ladders as usize {
                    bricks -= pq.pop().unwrap();
                }
                if bricks < 0 {
                    return i as i32;
                }
            }
        }
        heights.len() as i32 - 1
    }
}