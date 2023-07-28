impl Solution {
    pub fn count_collisions(directions: String) -> i32 {
        
        let mut count = 0;
        let mut left = 0;
        let mut right = 0;
        for c in directions.chars() {
            match c {
                'L' => {
                    left += 1;
                    count += right;
                },
                'R' => {
                    right += 1;
                },
                'S' => {
                    count += right;
                },
                _ => {}
            }
        }
        count
    }
}