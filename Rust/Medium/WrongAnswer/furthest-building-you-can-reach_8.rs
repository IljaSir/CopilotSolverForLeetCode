impl Solution {
    pub fn furthest_building(heights: Vec<i32>, bricks: i32, ladders: i32) -> i32 {
        
        let mut heights = heights;
        let mut ladders = ladders;
        let mut bricks = bricks;
        let mut idx = 0;
        let mut d = Vec::new();
        let n = heights.len();
        while idx < n - 1 {
            let h = heights[idx + 1] - heights[idx];
            if h > 0 {
                if ladders > 0 {
                    d.push(h);
                    d.sort();
                    ladders -= 1;
                } else if bricks >= h {
                    d.push(h);
                    d.sort();
                    bricks -= d.remove(0);
                } else {
                    break;
                }
            }
            idx += 1;
        }
        idx as i32
    }
}