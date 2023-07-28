impl Solution {
    pub fn asteroids_destroyed(mass: i32, asteroids: Vec<i32>) -> bool {
        
        let mut m = mass;
        for asteroid in asteroids {
            if asteroid > m {
                return false;
            }
            m += asteroid;
        }
        true
    }
}