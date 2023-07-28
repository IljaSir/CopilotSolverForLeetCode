impl Solution {
    pub fn furthest_building(heights: Vec<i32>, bricks: i32, ladders: i32) -> i32 {
        
        let mut bricks = bricks;
        let mut ladders = ladders;
        let mut diff = vec![];
        for i in 1..heights.len() {
            let d = heights[i] - heights[i-1];
            if d > 0 {
                if ladders > 0 {
                    ladders -= 1;
                    diff.push(d);
                    diff.sort();
                } else {
                    if d > bricks {
                        return (i-1) as i32;
                    } else {
                        bricks -= d;
                        diff.push(d);
                        diff.sort();
                        bricks += diff[0];
                        diff.remove(0);
                    }
                }
            }
        }
        (heights.len()-1) as i32
    }
}