impl Solution {
    pub fn furthest_building(heights: Vec<i32>, bricks: i32, ladders: i32) -> i32 {
        
        let mut bricks = bricks;
        let mut ladders = ladders;
        let mut pq = std::collections::BinaryHeap::new();
        for i in 1..heights.len() {
            let diff = heights[i] - heights[i - 1];
            if diff <= 0 { continue; }
            pq.push(diff);
            if pq.len() > ladders as usize {
                let min = pq.pop().unwrap();
                if min > bricks { return (i - 1) as i32; }
                bricks -= min;
            }
        }
        (heights.len() - 1) as i32
    }
}