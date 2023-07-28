impl Solution {
    pub fn count_collisions(directions: String) -> i32 {
        
        let mut left = 0;
        let mut right = 0;
        let mut collisions = 0;
        for c in directions.chars() {
            match c {
                'L' => left += 1,
                'R' => {
                    collisions += left;
                    right += 1;
                },
                _ => collisions += right,
            }
        }
        collisions
    }
}