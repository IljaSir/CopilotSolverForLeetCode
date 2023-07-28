impl Solution {
    pub fn furthest_building(heights: Vec<i32>, bricks: i32, ladders: i32) -> i32 {
        
        let mut bricks = bricks;
        let mut ladders = ladders;
        let mut diff = vec![];
        for i in 1..heights.len() {
            let h = heights[i] - heights[i - 1];
            if h > 0 {
                diff.push(h);
            }
        }
        diff.sort();
        for i in 0..diff.len() {
            if diff[i] <= bricks {
                bricks -= diff[i];
            } else if ladders > 0 {
                ladders -= 1;
            } else {
                return i as i32;
            }
        }
        (heights.len() - 1) as i32
    }
}