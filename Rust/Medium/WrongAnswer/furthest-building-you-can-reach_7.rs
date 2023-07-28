impl Solution {
    pub fn furthest_building(heights: Vec<i32>, bricks: i32, ladders: i32) -> i32 {
        
        let mut bricks = bricks;
        let mut ladders = ladders;
        let mut diff: Vec<i32> = Vec::new();
        for i in 0..heights.len()-1 {
            let d = heights[i+1] - heights[i];
            if d > 0 {
                diff.push(d);
            }
        }
        diff.sort();
        for i in 0..diff.len() {
            if ladders > 0 {
                ladders -= 1;
            } else if bricks >= diff[i] {
                bricks -= diff[i];
            } else {
                return (i-1) as i32;
            }
        }
        (diff.len()-1) as i32
    }
}