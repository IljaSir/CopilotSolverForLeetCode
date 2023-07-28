impl Solution {
    pub fn furthest_building(heights: Vec<i32>, bricks: i32, ladders: i32) -> i32 {
        
        let mut bricks = bricks;
        let mut ladders = ladders;
        let mut heap = std::collections::BinaryHeap::new();
        for i in 0..heights.len() - 1 {
            let diff = heights[i + 1] - heights[i];
            if diff > 0 {
                heap.push(-diff);
                if heap.len() > ladders as usize {
                    bricks -= heap.pop().unwrap();
                }
                if bricks < 0 {
                    return (i as i32);
                }
            }
        }
        (heights.len() - 1) as i32
    }
}