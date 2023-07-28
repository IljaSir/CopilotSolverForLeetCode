impl Solution {
    pub fn furthest_building(heights: Vec<i32>, bricks: i32, ladders: i32) -> i32 {
        
        let mut bricks = bricks;
        let mut ladders = ladders;
        let mut heap = std::collections::BinaryHeap::new();
        for i in 1..heights.len() {
            let d = heights[i] - heights[i - 1];
            if d > 0 {
                heap.push(d);
                if heap.len() > ladders as usize {
                    bricks -= heap.pop().unwrap();
                }
                if bricks < 0 {
                    return (i - 1) as i32;
                }
            }
        }
        (heights.len() - 1) as i32
    }
}