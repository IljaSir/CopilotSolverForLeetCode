impl Solution {
    pub fn count_collisions(directions: String) -> i32 {
        
        let mut collisions = 0;
        let mut left_car = 0;
        let mut right_car = 0;
        for i in 0..directions.len() {
            match directions.chars().nth(i).unwrap() {
                'L' => left_car += 1,
                'R' => right_car += 1,
                'S' => {
                    collisions += left_car * right_car;
                    left_car = 0;
                    right_car = 0;
                }
                _ => (),
            }
        }
        collisions
    }
}