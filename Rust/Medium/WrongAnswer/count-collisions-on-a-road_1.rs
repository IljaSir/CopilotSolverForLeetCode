impl Solution {
    pub fn count_collisions(directions: String) -> i32 {
        
        let mut collisions = 0;
        let mut left = 0;
        let mut right = 0;
        for c in directions.chars() {
            match c {
                'L' => left += 1,
                'R' => right += 1,
                'S' => {
                    let min = left.min(right);
                    collisions += min;
                    left -= min;
                    right -= min;
                },
                _ => {},
            }
        }
        collisions
    }
}